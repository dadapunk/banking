package com.dada.banking_project.models.DTO;

import com.dada.banking_project.models.Account;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AccountDTO {

    private BigDecimal balance;
    private String secretKey;
    private String primaryOwner;
    private String secondaryOwner;
    @Enumerated(EnumType.STRING)
    private String accountType;
    private String status;
    private BigDecimal penaltyFee;

    private Integer accounHolderId;

    public AccountDTO() {
    }

    public AccountDTO(BigDecimal balance, String primaryOwner, String secondaryOwner, String accountType,
                      String status, Integer accountHolderId) {
                        this.balance = balance;
                        this.primaryOwner = primaryOwner;
                        this.secondaryOwner = secondaryOwner;
                        this.accountType = accountType;
                        this.status = status;
                        this.accounHolderId = accountHolderId;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +

                ", balance=" + balance +
                ", secretKey='" + secretKey + '\'' +
                ", primaryOwner='" + primaryOwner + '\'' +
                ", secondaryOwner='" + secondaryOwner + '\'' +
                ", AccountType=" + accountType +
                ", status='" + status + '\'' +
                ", penaltyFee=" + penaltyFee +
                ", accounHolderId=" + accounHolderId +
                '}';
    }
}
