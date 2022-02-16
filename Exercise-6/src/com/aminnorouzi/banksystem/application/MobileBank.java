package com.aminnorouzi.banksystem.application;

import com.aminnorouzi.banksystem.helper.StringUtils;
import com.aminnorouzi.banksystem.model.Account;
import com.aminnorouzi.banksystem.model.Bank;
import com.aminnorouzi.banksystem.model.Customer;
import com.aminnorouzi.banksystem.model.TransactionStatus;

import java.math.BigDecimal;

public class MobileBank extends TransactionSystem implements Showable, Chargeable {
    private Bank receiverBank;

    public MobileBank(Bank bank, Customer customer, Account account, Bank receiverBank) {
        super(bank, customer, account);
        this.receiverBank = receiverBank;
    }

    @Override
    public void showBalance(String cardNumber) {
        try {
            System.out.println("Balance: " + findAccount(cardNumber, getBank()).getAccountBalance().doubleValue());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void buyCharge(BigDecimal amount) {
        try {
            validateWithdraw(getAccount(), amount);
            withdraw(amount);
            System.out.println("Charge: " + StringUtils.getRandomInt(16));
            logTransaction(getAccount().getAccountNumber(), amount, TransactionStatus.SUCCEED, null);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            logTransaction(getAccount().getAccountNumber(), amount, TransactionStatus.FAILED, null);
        }
    }

    @Override
    public void transfer(String receiverCardNumber, BigDecimal amount, String description) {
        try {
            Account receiverAccount = findAccount(receiverCardNumber, receiverBank);

            validateWithdraw(getAccount(), amount);
            withdraw(amount);

            validateDeposit(receiverAccount, amount);
            deposit(receiverAccount, amount);

            logTransaction(receiverAccount.getAccountNumber(), amount, TransactionStatus.SUCCEED, description);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            logTransaction(receiverCardNumber, amount, TransactionStatus.FAILED, description);
        }
    }

    @Override
    protected Account findAccount(String acc, Bank bank) throws Exception {
        for (Customer customer : bank.getCustomers()) {
            for (Account account : customer.getAccounts()) {
                if (account.getCreditCard().getCardNumber().equals(acc)) {
                    return account;
                }
            }
        }
        throw new Exception("Not a valid account");
    }
}
