package com.aminnorouzi.banksystem;

import com.aminnorouzi.banksystem.application.BankToBank;
import com.aminnorouzi.banksystem.application.Banking;
import com.aminnorouzi.banksystem.application.MobileBank;
import com.aminnorouzi.banksystem.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Q1 Answer
        /* Set Interface:
        A Set is a Collection that cannot contain duplicate elements. It models the mathematical set abstraction.
        The Set interface contains only methods inherited from Collection and adds the restriction that duplicate
        elements are prohibited. Set also adds a stronger contract on the behavior of the equals and hashCode
        operations, allowing Set instances to be compared meaningfully even if their implementation types differ.
        Two Set instances are equal if they contain the same elements.

        The Java platform contains three general-purpose Set implementations: HashSet, TreeSet, and LinkedHashSet.
        HashSet, which stores its elements in a hash table, is the best-performing implementation; however it makes
        no guarantees concerning the order of iteration. TreeSet, which stores its elements in a red-black tree,
        orders its elements based on their values; it is substantially slower than HashSet. LinkedHashSet, which is
        implemented as a hash table with a linked list running through it, orders its elements based on the order in
        which they were inserted into the set (insertion-order). LinkedHashSet spares its clients from the
        unspecified, generally chaotic ordering provided by HashSet at a cost that is only slightly higher.
         */

        // Q2 Answer
        /* hashCode():
        What is the default implementation of hashCode()?
        The value returned by the default implementation of hashCode() is called identity hash code so I will
        use this term from now on to distinguish it from the hash provided by overriden implementations of
        hashCode(). FYI: even if a class overrides hashCode(), you can always get the identity hash code of
        an object o by calling System.identityHashCode(o).
        Common wisdom is that the identity hash code uses the integer representation of the memory address.
        That’s also what the J2SE JavaDocs for Object.hashCode() imply:

                ... is typically implemented by converting the internal address of
                the object into an integer, but this implementation technique is not
                required by the Java programming language.

        Still, this seems problematic as the method contract requires that:

                Whenever it is invoked on the same object more than once during an
                execution of a Java application, the hashCode method must consistently
                return the same integer.

        Given that the JVM will relocate objects (e.g. during garbage collection cycles due to promotion or
        compaction), after we calculate an object’s identity hash we must be able to retain it in a way that survives
        object relocation.
        A possibility could be to take the current memory position of the object on the first call to hashCode(),
        and save it somewhere along with the object, like the object’s header. That way, if the object is moved to
        a different memory location, it would carry the original hash with it. A caveat of this method is that it
        won’t prevent two objects from having the same identity hash, but that’s allowed by the spec.

        The best confirmation would be to to look at the source. Unfortunately, the default
        java.lang.Object::hashCode() is a native function:

                public native int hashCode();

        Note that the identity hashCode() implementation is dependant on the JVM.
         */

        // Q3 Answer
        /* LinkedList:
        Since LinkedList implements the java.util.List interface, you can sort the LinkedList by using the
        Collections.sort() method, just like you sort an ArrayList. Since the LinkedList class implements the
        linked list data structure which doesn't provide random access based upon the index, sorting is quite
        expensive. In order to access any element, you need to first traverse through that element which is
        the O(n) operator. This method uses an efficient strategy to handle this scenario. It first copies the
        contents of LinkedList to an array, sorts the array, and copies it back.

        So it's as efficient as sorting an ArrayList. By default Collections.sort() arrange elements of a
        linked list into their natural order of sorting but it also accepts a Comparator, which can be used to
        sort elements in the custom order.

        Sorting LinkedList using Collections.sort():

            There are 2 ways to sort the LinkedList using Collection.sort() method, first, in the natural order
            which is imposed by the Comparable interface i.e. String are sorted in lexicographic order, Integers
            are sorted in numeric order and Dates are sorted in chronological order.

            On the second way, You can use pass your own Comparator to define the sorting strategy e.g. you can
            sort the LinkedList of String on their length. This method of sorting is available in Java since
            Java 1.2, hence, you can use it most of the JDK.

        Sorting LinkedList using List.sort():

            This is a relatively new way to sort LinkedList in Java. It is only available from Java 8 onward.
            Instead of calling Collections.sort(), you just call the list.sort() method. It behaves similarly
            to Collections.sort(), actually internally it just calls the Collection.sort() method.


        The Java.util.LinkedList.get() method is used to fetch or retrieve an element at a specific index
        from a LinkedList.
         */

        // Q4 Answer
        /* Accounts:
        [Account{accountNumber='b1accN11', iban='b1accI11', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@27973e9b}, Account{accountNumber='b1accN12', iban='b1accI12', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@312b1dae}]
        [Account{accountNumber='b1accN21', iban='b1accI21', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@7530d0a}, Account{accountNumber='b1accN22', iban='b1accI22', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@27bc2616}]
        [Account{accountNumber='b1accN31', iban='b1accI31', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@3941a79c}, Account{accountNumber='b1accN32', iban='b1accI32', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@506e1b77}]
        [Account{accountNumber='b1accN41', iban='b1accI41', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@4fca772d}, Account{accountNumber='b1accN42', iban='b1accI42', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@9807454}]

        [Account{accountNumber='b2accN11', iban='b2accI11', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@1ddc4ec2}, Account{accountNumber='b2accN12', iban='b2accI12', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@133314b}]
        [Account{accountNumber='b2accN21', iban='b2accI21', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@b1bc7ed}, Account{accountNumber='b2accN22', iban='b2accI22', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@7cd84586}]
        [Account{accountNumber='b2accN31', iban='b2accI31', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@30dae81}, Account{accountNumber='b2accN32', iban='b2accI32', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@1b2c6ec2}]
        [Account{accountNumber='b2accN41', iban='b2accI41', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@4edde6e5}, Account{accountNumber='b2accN42', iban='b2accI42', accountStatus=OPEN, accountBalance=0, creditCard=com.aminnorouzi.banksystem.model.CreditCard@70177ecd}]
         */

        Bank firstBank = new Bank("firstBank", "first", creatCustomers("b1"));
        Bank secondBank = new Bank("secondBank", "second", creatCustomers("b2"));

        // - - - - - - - - - - - - - - - - - - - -
        Banking banking = new Banking(firstBank, firstBank.getCustomers().get(0),
                firstBank.getCustomers().get(0).getAccounts().get(0));

        String bankingAccountNumber = firstBank.getCustomers().get(0).getAccounts().get(0).getAccountNumber();
        banking.showBalance(bankingAccountNumber);

        System.out.println();
        banking.deposit(new BigDecimal(10), "test d");
        banking.showBalance(bankingAccountNumber);
        System.out.println();
        banking.withdraw(new BigDecimal(2), "test w");
        banking.showBalance(bankingAccountNumber);
        System.out.println();
        banking.transfer(firstBank.getCustomers().get(1).getAccounts().get(0).getAccountNumber(), new BigDecimal(5),
                "test t");
        banking.showBalance(bankingAccountNumber);
        System.out.println();
        banking.showTransactions();

        // - - - - - - - - - - - - - - - - - - - -
        BankToBank bankToBank = new BankToBank(firstBank, firstBank.getCustomers().get(0),
                firstBank.getCustomers().get(0).getAccounts().get(0), secondBank);

        firstBank.getCustomers().get(0).getAccounts().get(0).setAccountBalance(new BigDecimal(10));

        System.out.println();
        bankToBank.transfer(secondBank.getCustomers().get(1).getAccounts().get(0).getIban(), new BigDecimal(8),
                "test t");
        System.out.println();
        bankToBank.showTransactions();

        // - - - - - - - - - - - - - - - - - - - -
        MobileBank mobileBank = new MobileBank(firstBank, firstBank.getCustomers().get(0),
                firstBank.getCustomers().get(0).getAccounts().get(0), secondBank);

        String mobileBankCardNumber = firstBank.getCustomers().get(0).getAccounts().get(0).getCreditCard().getCardNumber();
        mobileBank.showBalance(mobileBankCardNumber);

        firstBank.getCustomers().get(0).getAccounts().get(0).setAccountBalance(new BigDecimal(10));
        mobileBank.showBalance(mobileBankCardNumber);

        System.out.println();
        mobileBank.buyCharge(new BigDecimal(7));
        mobileBank.showBalance(mobileBankCardNumber);
        System.out.println();
        mobileBank.transfer(secondBank.getCustomers().get(1).getAccounts().get(0).getCreditCard().getCardNumber()
                , new BigDecimal(5), "test t");
        mobileBank.showBalance(mobileBankCardNumber);
        System.out.println();
        mobileBank.showTransactions();
    }

    private static List<Customer> creatCustomers(String str) {
        List<Customer> customers = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            customers.add(new Customer(null, null, null, creatAccounts(i, str),
                    new ArrayList<>()));
        }
        return customers;
    }

    private static List<Account> creatAccounts(int val, String str) {
        List<Account> accounts = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            accounts.add(new Account(str + "accN" + val + i, str + "accI" + val + i, AccountStatus.OPEN,
                    new BigDecimal(0), new CreditCard(str + "accN" + val + i, AccountStatus.OPEN,
                    new BigDecimal(0), str + "cardN" + val + i, null, null)));
        }
        return accounts;
    }
}
