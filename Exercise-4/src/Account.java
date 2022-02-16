import java.text.DecimalFormat;

public abstract class Account {
    private final int interest;
    private double balance;
    private final Currency currency;

    protected Account(int interest, double balance) {
        this.interest = interest;
        this.balance = balance;
        this.currency = Currency.IRR;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit (" + currency + "): " + format(amount));
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdraw (" + currency + "): " + format(amount));
    }

    public void show() {
        System.out.println("Balance (" + currency + "): " + format(balance));
    }

    public void calculate() {
        System.out.println("Interest (" + currency + "): " + format((balance * interest) / 100));
    }

    public String format(double value) {
        return new DecimalFormat("0.00").format(value);
    }

    public double getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }
}
