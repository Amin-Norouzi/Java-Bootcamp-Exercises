package com.aminnorouzi.banksystem.model;

import java.math.BigDecimal;
import java.util.Date;

public class CreditCard {
    private String accountNumber;
    private AccountStatus accountStatus;
    private BigDecimal cardBalance;
    private String cardNumber;
    private Date expirationDate;
    private String cvv2;

    public CreditCard(String accountNumber, AccountStatus accountStatus, BigDecimal cardBalance, String cardNumber, Date expirationDate, String cvv2) {
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.cardBalance = cardBalance;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv2 = cvv2;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public BigDecimal getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(BigDecimal cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }
}
