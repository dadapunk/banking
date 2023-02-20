package com.dada.banking_project.controllers.impl;

import com.dada.banking_project.dtos.ThirdPartyTransactionDTO;
import com.dada.banking_project.dtos.TransactionResponseDTO;
import com.dada.banking_project.services.impl.ThirdPartyService;
import com.dada.banking_project.services.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ThirdParty")
public class ThirdPartyController {
    @Autowired
    TransactionService transactionService;
    @Autowired
    ThirdPartyService thirdPartyService;

    @PostMapping("/newTransaction")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TransactionResponseDTO newThirdPartyTransaction(@RequestBody ThirdPartyTransactionDTO thirdPartyTransactionDTO){
        return thirdPartyService.createTransaction(thirdPartyTransactionDTO);
    }

}
