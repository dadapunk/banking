package com.dada.banking_project;

import com.dada.banking_project.repositories.*;
import com.dada.banking_project.services.impl.AdminService;
import com.dada.banking_project.services.impl.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import  com.dada.banking_project.models.Users.AccountHolder;
import  com.dada.banking_project.models.Users.Admin;
import  com.dada.banking_project.models.Accounts.SavingAccount;
import  com.dada.banking_project.models.Accounts.CreditCardAccount;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
public class AdminTest {
    @Autowired
    WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private MvcResult mvcResult;
    private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    SavingAccountRepository savingAccountRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    AccountHolder accountHolder;
    Admin admin;
    SavingAccount savingAccount;
    CreditCardAccount creditCardAccount;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CreditCardAccountRepository creditCardAccountRepository;
    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();

        accountHolder = accountHolderRepository.save(
                new AccountHolder(
                        "Account Holder Test",
                        "accountHolderTest",
                        "1234",
                        LocalDate.of(1892, 3, 7),
                        "acHoldtest@mail.com"
                )
        );
        admin = adminRepository.save(
                new Admin(
                        "Admin Test",
                        "adminTest",
                        "1234"
                )
        );
        savingAccount = savingAccountRepository.save(
                new SavingAccount(
                        new BigDecimal(200),
                        accountHolder
                )
        );
        userService.addRoleToUser("accountHolderTest", "ROLE_ACCOUNT_HOLDER");
        userService.addRoleToUser("adminTest", "ROLE_ADMIN");

    }
    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
        accountRepository.deleteAll();
    }

}