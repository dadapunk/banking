package com.dada.banking_project.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;

/**
 * Data transfer object representing an account to be created.
 */
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

    /**
     * Returns a string representation of the AccountDTO object.
     *
     * @return a string representation of the AccountDTO object.
     */
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
