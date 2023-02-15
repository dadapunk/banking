package com.dada.banking_project;

import com.dada.banking_project.models.*;
import com.dada.banking_project.repositories.AccountHolderRepository;
import com.dada.banking_project.repositories.SavingAccountRepository;
import com.dada.banking_project.services.AccountHolderService;
import com.dada.banking_project.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class BankingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService,
                          AccountHolderService accountHolderService,
                          AccountHolderRepository accountHolderRepository,
                          SavingAccountRepository savingAccountRepository) {
        return args -> {

            AccountHolder accHold1 = new AccountHolder("User1", 
                                                        LocalDate.of(1986, 8, 07),
                                                        "sebastian.v.a@riseup.net",
                                                        new Address("Girona",
                                                        "Catalunya",
                                                        "Mercaders",
                                                        17004));
            accountHolderRepository.save(accHold1);

            SavingAccount saving_acc1= new SavingAccount(BigDecimal.valueOf(2000),
                                        "Sebastian Velasquez", "", "status", accHold1);
            savingAccountRepository.save(saving_acc1);

        };
    }

}
