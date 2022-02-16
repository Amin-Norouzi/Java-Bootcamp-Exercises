package com.aminnorouzi.banksystem.application;

import com.aminnorouzi.banksystem.model.Account;
import com.aminnorouzi.banksystem.model.Bank;
import com.aminnorouzi.banksystem.model.Customer;
import com.aminnorouzi.banksystem.model.TransactionStatus;

import java.math.BigDecimal;

public class BankToBank extends TransactionSystem {
    private Bank receiverBank;

    public BankToBank(Bank bank, Customer customer, Account account, Bank receiverBank) {
        super(bank, customer, account);
        this.receiverBank = receiverBank;
    }

    @Override
    public void transfer(String receiverIban, BigDecimal amount, String description) {
        try {
            Account receiverAccount = findAccount(receiverIban, receiverBank);

            validateWithdraw(getAccount(), amount);
            withdraw(amount);

            validateDeposit(receiverAccount, amount);
            deposit(receiverAccount, amount);

            logTransaction(receiverAccount.getAccountNumber(), amount, TransactionStatus.SUCCEED, description);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            logTransaction(receiverIban, amount, TransactionStatus.FAILED, description);
        }
    }

    @Override
    protected Account findAccount(String acc, Bank bank) throws Exception {
        for (Customer customer : bank.getCustomers()) {
            for (Account account : customer.getAccounts()) {
                if (account.getIban().equals(acc)) {
                    return account;
                }
            }
        }
        throw new Exception("Not a valid account");
    }
}
