package com.aminnorouzi;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Answer Q1
        /*
        Lambda expression vs anonymous inner class:

        An anonymous inner class (AIC) can be used to create a subclass of an abstract class or a concrete class.
        An AIC can also provide a concrete implementation of an interface, including the addition of state (fields).
        An instance of an AIC can be referred to using this in its method bodies, so further methods can be called
        on it, its state can be mutated over time, etc. None of these apply to lambdas. Key differences:

            - Anonymous Inner classes can be used in case of more than one abstract method while a lambda expression
              specifically used for functional interfaces.

            - It can use instance variables and thus can have state, lambdas cannot.

            - Anonymous inner classes have support to access variables from the enclosing context. It has access to
              all final variables of its enclosing context.

            - We need to provide the function body only in lambda expression while in the case of an anonymous class,
              we need to write the redundant class definition.
         */

        // Answer Q2
        /*
        Process vs thread:

        Both processes and threads are independent sequences of execution. The typical difference is that
        threads (of the same process) run in a shared memory space, while processes run in separate memory
        spaces. Key differences:

            - A process is independent and does not contain within another process, whereas all threads are
              logically contained within a process.

            - Processes are heavily weighted, whereas threads are light-weighted.

            - A process can exist individually as it contains its own memory and other resources, whereas a thread
              cannot have its individual existence.

            - A proper synchronization between processes is not required. In contrast, threads need to be synchronized
              in order to avoid unexpected scenarios.

            - Processes can communicate with each other using inter-process communication only; in contrast, threads
              can directly communicate with each other as they share the same address space.
         */

        // Answer Q3
        /*
        Type erasure:

        Generics are used for tighter type checks at compile time and to provide a generic programming. To implement
        generic behaviour, java compiler apply type erasure. Type erasure is a process in which compiler replaces a
        generic parameter with actual class or bridge method. In type erasure, compiler ensures that no extra classes
        are created and there is no runtime overhead.
         */

        // Answer Q4
        /*
        Dependency management:

        Dependency Management allows to consolidate and centralize the management of dependency versions without
        adding dependencies which are inherited by all children. This is especially useful when you have a set of
        projects (i.e. more than one) that inherits a common parent.

        Another extremely important use case of dependencyManagement is the control of versions of artifacts used
        in transitive dependencies.
         */

        // Answer Q5
        Account account = new Account(new BigDecimal(80), new ArrayList<>());
        account.transfer(new BigDecimal(10));

        // Answer Q6
        // safe
        runSafeTransfers(account);
        // not safe (it might not work as expected!)
        runNotSafeTransfers(account);

        Thread.sleep(1000);
        System.out.println(account.getTransactions());
        System.out.println(account.getBalance());

        // Answer Q7
        /*
        H. The code does not compile
        java.lang.IllegalMonitorStateException: current thread is not owner
         */
    }

    private static void runSafeTransfers(Account account) {
        Thread customerA = new Thread(() -> account.transfer(new BigDecimal(20)));
        Thread customerB = new Thread(() -> account.transfer(new BigDecimal(30)));

        customerA.start();
        customerB.start();
    }

    private static void runNotSafeTransfers(Account account) {
        Thread customerA = new Thread(() -> account.notSafeTransfer(new BigDecimal(40)));
        Thread customerB = new Thread(() -> account.notSafeTransfer(new BigDecimal(50)));

        customerA.start();
        customerB.start();
    }
}
