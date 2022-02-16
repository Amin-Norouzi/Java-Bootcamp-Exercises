public class Main {
    public static void main(String[] args) {

        // Answer Q1
        /*
        Object class:

        It is not a explicit requirement forced on the developer. If a class is declared without
        extending another class then it will implicitly extend Object class. This is taken care
        of by the JVM. This is not applicable for the interfaces. A Java interface does not extends
        the Object.

        Following could be the reasons for this design decision,

            1. By having the Object as the super class of all Java classes, without knowing the type
               we can pass around objects using the Object declaration.

            2. Before generics was introduced, imagine the state of heterogeneous Java collections.
               A collection class like ArrayList allows to store any type of classes. It was made
               possible only by Object class hierarchy.

            3. The other reason would be to bring a common blueprint for all classes and have some
               list of functions same among them. I am referring to methods like hashCode(), clone(),
               toString() and methods for threading which is defined in Object class.

        This concept cannot be generalized to all object oriented programming (OOPS) languages. For instance,
        in C++ there is no such super class of all classes.
         */

        String str = new String("Hi");
        Class strClass = str.getClass();
        System.out.println("Super class of String: " + strClass.getSuperclass());

        Object obj = new Object();
        Class objClass = obj.getClass();
        System.out.println("Super class of Object: " + objClass.getSuperclass());

        Class classClass = objClass.getClass();
        System.out.println("Super class of Class: " + classClass.getSuperclass());

        // Answer Q2
        /*
        In Java, a class cannot extend more than one class. Therefore following is illegal −
            public class extends Animal, Mammal{}

        However, a class can implement one or more interfaces, which has helped Java get rid
        of the impossibility of multiple inheritances.
        The reason behind this is to prevent ambiguity. Consider a case where class B extends
        class A and Class C and both class A and C have the same method display(). Now java
        compiler cannot decide, which display method it should inherit. To prevent such situation,
        multiple inheritances is not allowed in java.
         */


        // Answer Q3
        /*
        Overloading allows different methods to have the same name, but different signatures where
        the signature can differ by the number of input parameters or type of input parameters or both.
        Overloading is related to compile-time (or static) polymorphism.

        Can we overload methods on return type?
        We cannot overload by return type. Refer this for details

            private static int test() {
                return 10;
            }

            // compiler error: test() is already defined
            private static String test() {
                return "10";
            }

        Return types and access modifiers are not qualifying factors for method overloading. As said before,
        what qualifies methods as being overloaded are the parameters that are passed, i.e, either the type
        of parameters, the number of parameters passed, or both.
         */

        // Answer Q4
        Square square = new Square(10);
        square.calculateArea();
        square.calculatePerimeter();
        square.showResults();

        Circle circle = new Circle(10);
        circle.calculateArea();
        circle.calculatePerimeter();
        circle.showResults();

        Triangle triangle = new Triangle(10, 10, 15, 12);
        triangle.calculateArea();
        triangle.calculatePerimeter();
        triangle.showResults();

        // Answer Q5
        /*
        The answer is E(This code does not compile). Because x variable has protected
        access which makes it not accessible in "com.package2.Child".

        Error: java: x has protected access in com.package1.Parent
         */
    }
}
