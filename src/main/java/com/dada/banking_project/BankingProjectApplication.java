package com.dada.banking_project;

import com.dada.banking_project.models.*;
import com.dada.banking_project.dtos.AccountDTO;
import com.dada.banking_project.models.Accounts.*;
import com.dada.banking_project.models.Users.AccountHolder;
import com.dada.banking_project.models.Users.ThirdParty;
import com.dada.banking_project.models.Users.User;
import com.dada.banking_project.repositories.*;
import com.dada.banking_project.services.impl.AdminService;
import com.dada.banking_project.services.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class BankingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingProjectApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Bean
    CommandLineRunner run(SavingAccountRepository savingAccountRepository,
                          CreditCardAccountRepository creditCardAccountRepository,
                          CheckingAccountRepository checkingAccountRepository,
                          StudentCheckingAccountRepository studentCheckingAccountRepository,
                          UserService userService,
                          AdminService adminService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_THIRD_PARTY"));
            userService.saveRole(new Role(null, "ROLE_ACCOUNT_HOLDER"));

            // Create an account Holder User
            AccountHolder accountHolder1 = new AccountHolder(null,"John Doe", "john",
                    "1234",new ArrayList<>(), LocalDate.of(1990,8,9),"",
                    null);
            AccountHolder accountHolder2 = new AccountHolder(null,"Jane Carry", "jane",
                    "1234",new ArrayList<>(), LocalDate.of(2000,4,3),"",
                    null);
            userService.saveUser(accountHolder1);
            userService.saveUser(accountHolder2);
            userService.saveUser(new User(null, "Chris Anderson", "chris",
                    "1234", new ArrayList<>()));
            // Admin User
            userService.saveUser(new User(null, "Sebastian Velasquez", "dadapunk",
                    "1234", new ArrayList<>()));
            // Third Party User
            ThirdParty thirdPartyUser = new ThirdParty(null, "Wendy Jove", "Wendy",
                    "1234", new ArrayList<>());

            // Assign Roles to Users
            userService.addRoleToUser("john", "ROLE_ACCOUNT_HOLDER");
            userService.addRoleToUser("jane", "ROLE_ACCOUNT_HOLDER");
            userService.addRoleToUser("chris", "ROLE_ADMIN");
            userService.addRoleToUser("chris", "ROLE_USER");
            userService.addRoleToUser("dadapunk", "ROLE_ADMIN");

            // CREATE ACCOUNTS
            // SAVING ACCOUNT

            // Create SavingAccount associated with AccountHolder 1
            SavingAccount savingAccount1 = new SavingAccount(BigDecimal.valueOf(1200), "John Doe",
                    "", "ACTIVE", accountHolder1);
            savingAccount1.setMinimumBalance(BigDecimal.valueOf(1200)); // set the minimum balance
            savingAccount1.setInterestRate(BigDecimal.valueOf(0.02)); // set the interest rate
            savingAccountRepository.save(savingAccount1);

            // Create SavingAccount associated with AccountHolder 2
            SavingAccount savingAccount2 = new SavingAccount(BigDecimal.valueOf(3500),
                    "Jane Carry", "", "ACTIVE", accountHolder2);
            savingAccount2.setMinimumBalance(BigDecimal.valueOf(1000)); // set the minimum balance
            savingAccount2.setInterestRate(BigDecimal.valueOf(0.05)); // set the interest rate
            savingAccountRepository.save(savingAccount2);

            // Create another SavingAccount associated with AccountHolder 2
            SavingAccount savingAccount3 = new SavingAccount(BigDecimal.valueOf(3000),
                    "Jane Carry", "", "ACTIVE", accountHolder2);
            savingAccount3.setMinimumBalance(BigDecimal.valueOf(1000)); // set the minimum balance
            savingAccount3.setInterestRate(BigDecimal.valueOf(0.05)); // set the interest rate
            savingAccountRepository.save(savingAccount3);

            // CREDIT CARD

            // Create CreditCardAccount associated with AccountHolder 1
            CreditCardAccount creditCardAccount1 = new CreditCardAccount(BigDecimal.valueOf(500),
                    "John Doe", "", "ACTIVE", accountHolder1);
            creditCardAccount1.setCreditLimit(BigDecimal.valueOf(10000)); // set the credit limit
            creditCardAccount1.setInterestRate(BigDecimal.valueOf(0.15)); // set the interest rate
            creditCardAccountRepository.save(creditCardAccount1);

            // Create CreditCardAccount associated with AccountHolder 2
            CreditCardAccount creditCardAccount2 = new CreditCardAccount(BigDecimal.valueOf(2000),
                    "Jane Carry", "", "ACTIVE", accountHolder2);
            creditCardAccount2.setCreditLimit(BigDecimal.valueOf(100)); // set the credit limit
            creditCardAccount2.setInterestRate(BigDecimal.valueOf(0.2)); // set the interest rate
            creditCardAccountRepository.save(creditCardAccount2);

            // CHECKING ACCOUNT FROM ACC HOLDER LESS THAN 24 YEARS OLD
            CheckingAccount checkingAccount = new CheckingAccount(BigDecimal.valueOf(700),"Jane Carry",
                    "","ACTIVE",accountHolder2);
            adminService.addAccount(new AccountDTO(BigDecimal.valueOf(900),
                    "Jane Carry", "Ben Carry", "CHECKING",
                    "ACTIVE", accountHolder2.getId().intValue()));
            //checkingAccountRepository.save(checkingAccount);

            // STUDENT ACCOUNT

            // Create a checking account for the student
            StudentCheckingAccount studentCheckingAccount = new StudentCheckingAccount(BigDecimal.valueOf(250),
                    "Alan Doe", "John Doe", "ACTIVE", accountHolder1);
            studentCheckingAccountRepository.save(studentCheckingAccount);




        };
    }


};
