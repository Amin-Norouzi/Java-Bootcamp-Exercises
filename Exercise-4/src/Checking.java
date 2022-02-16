public class Checking extends Account{
    private static final int INTEREST = 10;

    public Checking(double balance) {
        super(INTEREST, balance);
    }
}
