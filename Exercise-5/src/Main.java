public class Main {
    public static void main(String[] args) {

        // Answer Q1
        /*
        Logical || and && check the right hand side only if necessary. The | and & check both the sides everytime.

        & , &&:
            & is bitwise. && is logical.
            & evaluates both sides of the operation. && evaluates the left side of the operation, if it's true,
            it continues and evaluates the right side.

        |, ||:
            It is the same thing with | and ||.
            || will stop evaluating if the left side of the operation is true, but | won't. In addition, | can
            be used to perform the bitwise-OR operation on byte/short/int/long values. || cannot.
         */

        int a = 14;
        int b = 20;
        int c = 10;

        // & , &&:
        if (firstCondition(a,b) & secondCondition(a, c)) {
            printSomething("if with & ran.");
        }

        printSomething("- - - - -");

        if (firstCondition(a,b) && secondCondition(a, c)) {
            printSomething("if with && ran.");
        }

        printSomething("- - - - -");

        // |, ||:
        if (firstCondition(a,c) | secondCondition(a, b)) {
            printSomething("if with | ran.");
        }

        printSomething("- - - - -");

        if (firstCondition(a,c) || secondCondition(a, b)) {
            printSomething("if with || ran.");
        }

        // Answer Q2
        /*
        Overriding method can not throw checked Exception higher in hierarchy than thrown by overridden method.
        Let’s say for example overridden method in parent class throws FileNotFoundException, the overriding
        method in child class can throw FileNotFoundException; but it is not allowed to throw IOException or
        Exception, because IOException or Exception are higher in hierarchy i.e. super classes of FileNotFoundException.

        More to it, you can omit the exception declaration from overriding method. It’s allowed and perfectly valid.
        Also overriding method can throw any unchecked (runtime) exception, regardless of whether the overridden
        method declares the exception.

        Thrown exceptions from methods are also not considered when overloading a method. So your overloaded
        method throws the same exception, a different exception or it simply does no throw any exception; no
        effect at all on method loading.
         */

    }

    private static boolean firstCondition(int val1, int val2) {
        boolean result = val1 > val2;
        printSomething("firstCondition() ran. " + result);
        return result;
    }

    private static boolean secondCondition(int val1, int val2) {
        boolean result = val1 > val2;
        printSomething("secondCondition() ran. " + result);
        return result;
    }

    private static void printSomething(String str) {
        System.out.println(str);
    }

}
