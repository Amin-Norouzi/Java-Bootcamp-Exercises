package com.aminnorouzi;

import java.math.BigDecimal;
import java.util.List;

public class LogTransaction extends Thread {
    private BigDecimal amount;
    private List<Transaction> transactions;

    public LogTransaction(BigDecimal amount, List<Transaction> transactions) {
        this.amount = amount;
        this.transactions = transactions;
    }

    @Override
    public void run() {
        transactions.add(new Transaction(amount));
    }
}
