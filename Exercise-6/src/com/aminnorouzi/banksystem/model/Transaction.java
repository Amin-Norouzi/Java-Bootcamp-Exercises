package com.aminnorouzi.banksystem.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private BigDecimal transactionAmount;
    private Date transactionDate;
    private TransactionStatus transactionStatus;
    private String transactionDescription;

    public Transaction(String senderAccountNumber, String receiverAccountNumber, BigDecimal transactionAmount, Date transactionDate, TransactionStatus transactionStatus, String transactionDescription) {
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.transactionStatus = transactionStatus;
        this.transactionDescription = transactionDescription;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "senderAccountNumber='" + senderAccountNumber + '\'' +
                ", receiverAccountNumber='" + receiverAccountNumber + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transactionDate=" + transactionDate +
                ", transactionStatus=" + transactionStatus +
                ", transactionDescription='" + transactionDescription + '\'' +
                '}';
    }
}
