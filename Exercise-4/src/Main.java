public class Main {
    public static void main(String[] args) {

        // Answer Q1
        /*
        If a type implements two interfaces, and each interface define a method that has identical signature,
        then in effect there is only one method, and they are not distinguishable. If, say, the two methods
        have conflicting return types, then it will be a compilation error.

        Note that there is only one @Override necessary!
         */

        InterfaceTest test = new InterfaceTest();
        test.print();

        // Answer Q2
        System.out.println("\nChecking: ");
        Checking checking = new Checking(5460000);
        checking.show();
        checking.deposit(40000);
        checking.show();
        checking.withdraw(500000);
        checking.show();
        checking.calculate();

        System.out.println("\nShort Term: ");
        ShortTerm shortTerm = new ShortTerm(1200000);
        shortTerm.show();
        shortTerm.deposit(100000);
        shortTerm.show();
        shortTerm.withdraw(300000);
        shortTerm.show();
        shortTerm.calculate();

        System.out.println("\nLong Term: ");
        LongTerm longTerm = new LongTerm(5000000);
        longTerm.show();
        longTerm.deposit(1200000);
        longTerm.show();
        longTerm.withdraw(200000);
        longTerm.show();
        longTerm.calculate();
        longTerm.calculate(8);
        longTerm.calculate(Currency.USD);
        longTerm.calculate(Currency.EUR);
        // Minimum will be 0 because it's greater than main balance
        longTerm = new LongTerm(500000, 100000);
        longTerm.show();

    }
}
