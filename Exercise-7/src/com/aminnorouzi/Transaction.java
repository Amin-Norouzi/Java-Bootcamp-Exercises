package com.aminnorouzi;

import java.math.BigDecimal;

public class Transaction {
    private BigDecimal balance;

    public Transaction(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "balance=" + balance +
                '}';
    }
}
