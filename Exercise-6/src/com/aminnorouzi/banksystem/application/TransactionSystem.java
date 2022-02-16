package com.aminnorouzi.banksystem.application;

import com.aminnorouzi.banksystem.model.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class TransactionSystem {
    private final Bank bank;
    private final Customer customer;
    private final Account account;

    protected TransactionSystem(Bank bank, Customer customer, Account account) {
        this.bank = bank;
        this.customer = customer;
        this.account = account;
    }

    protected void validateDeposit(Account account, BigDecimal amount) throws Exception {
        isValidAmount(amount);
        isOpenAccount(account);
    }

    protected void validateWithdraw(Account account, BigDecimal amount) throws Exception {
        isValidAmount(amount);
        isValidBalance(amount);
        isOpenAccount(account);
    }

    public void showTransactions() {
        customer.getTransactions().forEach(t -> System.out.println(t));
    }

    protected void logTransaction(String receiver, BigDecimal amount, TransactionStatus status, String description) {
        Date date = new GregorianCalendar().getTime();
        customer.getTransactions().add(new Transaction(account.getAccountNumber(), receiver,
                amount, date, status, description));
    }

    private void isOpenAccount(Account account) throws Exception {
        if (account.getAccountStatus().equals(AccountStatus.CLOSE)) {
            throw new Exception("Account is not open");
        }
    }

    private void isValidAmount(BigDecimal amount) throws Exception {
        if (amount.doubleValue() < 0) {
            throw new Exception("Amount should be greater than zero");
        }
    }

    private void isValidBalance(BigDecimal amount) throws Exception {
        if (account.getAccountBalance().doubleValue() <= amount.doubleValue()) {
            throw new Exception("Balance is not enough");
        }
    }

    protected void deposit(Account account, BigDecimal amount) {
        account.setAccountBalance(account.getAccountBalance().add(amount));
        account.getCreditCard().setCardBalance(account.getCreditCard().getCardBalance().add(amount));
    }

    protected void withdraw(BigDecimal amount) {
        account.setAccountBalance(account.getAccountBalance().subtract(amount));
        account.getCreditCard().setCardBalance(account.getCreditCard().getCardBalance().subtract(amount));
    }

    public abstract void transfer(String receiver, BigDecimal amount, String description);

    protected abstract Account findAccount(String acc, Bank bank) throws Exception;

    public Bank getBank() {
        return bank;
    }

    public Account getAccount() {
        return account;
    }
}
