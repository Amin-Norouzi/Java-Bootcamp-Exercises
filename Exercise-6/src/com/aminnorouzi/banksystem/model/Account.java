package com.aminnorouzi.banksystem.model;

import java.math.BigDecimal;

public class Account {
    private String accountNumber;
    private String iban;
    private AccountStatus accountStatus;
    private BigDecimal accountBalance;
    private CreditCard creditCard;

    public Account(String accountNumber, String iban, AccountStatus accountStatus, BigDecimal accountBalance, CreditCard creditCard) {
        this.accountNumber = accountNumber;
        this.iban = iban;
        this.accountStatus = accountStatus;
        this.accountBalance = accountBalance;
        this.creditCard = creditCard;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", iban='" + iban + '\'' +
                ", accountStatus=" + accountStatus +
                ", accountBalance=" + accountBalance +
                ", creditCard=" + creditCard +
                '}';
    }
}
