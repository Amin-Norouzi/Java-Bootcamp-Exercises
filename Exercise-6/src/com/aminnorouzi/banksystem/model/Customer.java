package com.aminnorouzi.banksystem.model;

import java.util.List;
import java.util.Objects;

public class Customer {
    private String fullName;
    private String nationalId;
    private String customerId;
    private List<Account> accounts;
    private List<Transaction> transactions;

    public Customer(String fullName, String nationalId, String customerId, List<Account> accounts, List<Transaction> transactions) {
        this.fullName = fullName;
        this.nationalId = nationalId;
        this.customerId = customerId;
        this.accounts = accounts;
        this.transactions = transactions;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId.equals(customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }
}
