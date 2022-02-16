package com.aminnorouzi;

import java.math.BigDecimal;
import java.util.List;

public class Account {
    private BigDecimal balance;
    private List<Transaction> transactions;

    public Account(BigDecimal balance, List<Transaction> transactions) {
        this.balance = balance;
        this.transactions = transactions;
    }

    private void logTransaction(BigDecimal amount) {
        new LogTransaction(amount, transactions).start();
    }

    public synchronized void transfer(BigDecimal amount) {
        balance = balance.subtract(amount);
        logTransaction(amount);
    }

    public void notSafeTransfer(BigDecimal amount) {
        balance = balance.subtract(amount);
        logTransaction(amount);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
