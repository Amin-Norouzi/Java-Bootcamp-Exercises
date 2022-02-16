public class LongTerm extends Account {
    private static final int INTEREST = 12;
    private static final double DOLLAR = 271800;
    private static final double EURO = 334110;

    private double minimum;

    public LongTerm(double balance) {
        super(INTEREST, balance);
    }

    public LongTerm(double balance, double minimum) {
        super(INTEREST, balance);
        if (validate(minimum)) {
            this.minimum = minimum;
        }
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("You can not withdraw in this account.");
    }

    public void calculate(Currency currency) {
        switch (currency) {
            case USD -> System.out.println("Interest (" + currency + "): "
                    + format(((getBalance() / DOLLAR) * INTEREST) / 100));

            case EUR -> System.out.println("Interest (" + currency + "): "
                    + format(((getBalance() / EURO) * INTEREST) / 100));

            default -> System.out.println("Wrong currency!");
        }
    }

    public void calculate(int count) {
        System.out.println("Interest (" + getCurrency() + ") * " + count + ": "
                + format((((getBalance() * INTEREST) / 100) * count)));
    }

    private boolean validate(double minimum) {
        if (minimum > getBalance()) {
            System.out.println("Minimum balance can not be less than main balance");
            return false;
        }
        return true;
    }
}
