package com.aminnorouzi.banksystem.application;

import com.aminnorouzi.banksystem.model.*;

import java.math.BigDecimal;

public class Banking extends TransactionSystem implements Showable, Cashable {

    public Banking(Bank bank, Customer customer, Account account) {
        super(bank, customer, account);
    }

    @Override
    public void showBalance(String accountNumber) {
        try {
            System.out.println("Balance: " + findAccount(accountNumber, getBank()).getAccountBalance().doubleValue());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deposit(BigDecimal amount, String description) {
        try {
            validateDeposit(getAccount(), amount);
            deposit(getAccount(), amount);
            logTransaction(getAccount().getAccountNumber(), amount, TransactionStatus.SUCCEED, description);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            logTransaction(getAccount().getAccountNumber(), amount, TransactionStatus.FAILED, description);
        }
    }

    @Override
    public void withdraw(BigDecimal amount, String description) {
        try {
            validateWithdraw(getAccount(), amount);
            withdraw(amount);
            logTransaction(getAccount().getAccountNumber(), amount, TransactionStatus.SUCCEED, description);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            logTransaction(getAccount().getAccountNumber(), amount, TransactionStatus.FAILED, description);
        }
    }

    @Override
    public void transfer(String receiverAccountNumber, BigDecimal amount, String description) {
        try {
            Account receiverAccount = findAccount(receiverAccountNumber, getBank());

            validateWithdraw(getAccount(), amount);
            withdraw(amount);

            validateDeposit(receiverAccount, amount);
            deposit(receiverAccount, amount);

            logTransaction(receiverAccountNumber, amount, TransactionStatus.SUCCEED, description);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            logTransaction(receiverAccountNumber, amount, TransactionStatus.FAILED, description);
        }
    }

    @Override
    protected Account findAccount(String acc, Bank bank) throws Exception {
        for (Customer customer : bank.getCustomers()) {
            for (Account account : customer.getAccounts()) {
                if (account.getAccountNumber().equals(acc)) {
                    return account;
                }
            }
        }
        throw new Exception("Not a valid account");
    }
}

