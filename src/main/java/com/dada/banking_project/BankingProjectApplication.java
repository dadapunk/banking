package com.dada.banking_project;

import com.dada.banking_project.models.*;
import com.dada.banking_project.models.DTO.AccountDTO;
import com.dada.banking_project.models.DTO.AccountHolderDTO;
import com.dada.banking_project.models.Enum.AccountType;
import com.dada.banking_project.repositories.*;
import com.dada.banking_project.services.AccountHolderService;
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
    CommandLineRunner run(AccountHolderRepository accountHolderRepository,
                          AccountHolderService accountHolderService,
                          SavingAccountRepository savingAccountRepository,
                          CheckingAccountRepository checkingAccountRepository,
                          AccountRepository accountRepository,
                          UserRepository userRepository,
                          UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_THIRD_PARTY"));
            userService.saveRole(new Role(null, "ROLE_ACCOUNT_HOLDER"));

            userService.saveUser(new User(null, "John Doe", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "James Smith", "james", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Jane Carry", "jane", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Chris Anderson", "chris", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Sebastian Velasquez", "dadapunk", "1234", new ArrayList<>()));

            // Create account Holder User
            AccountHolder accountHolder1 = new AccountHolder(null,"John Doe", "john",
                    "1234",new ArrayList<>(), LocalDate.of(1990,8,9),"",
                    null);
            // Assign Role to Users
            userService.addRoleToUser("john", "ROLE_ACCOUNT_HOLDER");
            userService.addRoleToUser("james", "ROLE_ADMIN");
            userService.addRoleToUser("jane", "ROLE_USER");
            userService.addRoleToUser("chris", "ROLE_ADMIN");
            userService.addRoleToUser("chris", "ROLE_USER");
            userService.addRoleToUser("dadapunk", "ROLE_ADMIN");

            // Create Accounts
            // Create SavingAccount associated with AccountHolder 1
            /*SavingAccount saving_acc1 = new SavingAccount(BigDecimal.valueOf(2000),
                    "John Doe", "", "status", accountHolder1);
            savingAccountRepository.save(saving_acc1);*/

            /*// Create CheckingAccount associated with AccountHolder 2
            CheckingAccount checking_acc2 = new CheckingAccount(BigDecimal.valueOf(1500),
                    "John Smith", "Jane Smith", "status", accHold_2);
            checkingAccountRepository.save(checking_acc2);*/
        };
    }


};
