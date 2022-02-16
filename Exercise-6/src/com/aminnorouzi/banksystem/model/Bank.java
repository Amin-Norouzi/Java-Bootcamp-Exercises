package com.aminnorouzi.banksystem.model;

import java.util.List;

public class Bank {
    private String bankName;
    private String branch;
    private List<Customer> customers;

    public Bank(String bankName, String branch, List<Customer> customers) {
        this.bankName = bankName;
        this.branch = branch;
        this.customers = customers;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
