public class Main {
    public static void main(String[] args) {
        // 1
        println("\nAnswer Q1:");
        int total = 0;
        for (int i = 1; i <= 100; i++) {
            total += i;
        }
        double average = (double) total / 100;
        println("Total: " + total + "\nAverage: " + average);

        // 2
        println("\nAnswer Q2:");
        int count = 1;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                print(count++ + "\t");
            }
            println("");
        }

        // 3
        println("\nAnswer Q3:");
        /*
        Key Differences Between if-else and switch:

        1. The expression inside if statement decides whether to execute the
        statements inside if block or under else block. On the other hand,
        the expression inside a switch statement decides which case to execute.

        2. You can have multiple if statement for multiple choice of statements.
        In switch, you only have one expression for the multiple choices.

        3. If-else statement checks for equality as well as for logical expression.
        On the other hand, switch checks only for equality.
        */
        println("4. The if statement evaluates integer, character, pointer or floating-point\n" +
                "type or boolean type. On the other hand, switch statement evaluates only character,\n" +
                "byte, short, and integer primitive data types. Supported data types in Java SE 8 switch statement:\n" +
                "int and Integer\n" +
                "byte and Byte\n" +
                "short and Short\n" +
                "char and Character\n" +
                "int and Integer\n" +
                "String\n" +
                "enum values\n");
        /*
        5. Sequence of execution is like either statement under if block will execute or
        statements under else block statement will execute. On the other hand, the expression
        in switch statement decide which case to execute and if you do not apply a break statement
        after each case it will execute till the end of the switch statement.
        */
        println("6. If expression inside if turn outs to be false, statement inside else block will be executed.\n" +
                "If expression inside switch statement turns out to be false then default statements is executed.\n" +
                "Default statement can be used anywhere in a switch block but note that if it is used as the last\n" +
                "statement, it does not need a break.");
        /*
        7. It is difficult to edit if-else statements as it is tedious to trace where the correction is
        required. On the other hand, it is easy to edit switch statements as they are easy to trace.
         */
    }

    public static void println(String str) {
        System.out.println(str);
    }

    public static void print(String str) {
        System.out.print(str);
    }
}
