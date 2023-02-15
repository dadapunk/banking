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
    private Integer id;
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

    public AccountDTO(BigDecimal balance, String secretKey,
                      String primaryOwner, String secondaryOwner, String accountType,
                      String status, BigDecimal penaltyFee, Integer accountHolderId) {
                        this.balance = balance;
                        this.secretKey = secretKey;
                        this.primaryOwner = primaryOwner;
                        this.secondaryOwner = secondaryOwner;
                        this.accountType = accountType;
                        this.status = status;
                        this.penaltyFee = penaltyFee;
                        this.accounHolderId = accountHolderId;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
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
