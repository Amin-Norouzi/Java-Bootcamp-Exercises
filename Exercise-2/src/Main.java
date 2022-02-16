public class Main {
    public static void main(String[] args) throws Throwable {
        /*
        The finalize() method of Object class is a method that the Garbage Collector always calls just before the
        deletion/destroying the object which is eligible for Garbage Collection, so as to perform clean-up activity.
        Clean-up activity means closing the resources associated with that object like Database Connection, Network
        Connection or we can say resource de-allocation. Remember it is not a reserved keyword. Once the finalize method
        completes immediately Garbage Collector destroy that object.

        Syntax:
            protected void finalize throws Throwable{}

        Since Object class contains the finalize method hence finalize method is available for every java class since
        Object is the superclass of all java classes. Since it is available for every java class hence Garbage Collector
        can call the finalize method on any java object.

        Why finalize method is used()?
        finalize() method releases system resources before the garbage collector runs for a specific object. JVM allows
        finalize() to be invoked only once per object.

        How to override finalize() method?
        Now, the finalize method which is present in the Object class, has an empty implementation, in our class clean-up
        activities are there, then we have to override this method to define our own clean-up activities.
         */

        FinalizeDemo finalizeDemo = new FinalizeDemo();
        finalizeDemo.finalize();
    }
}

class FinalizeDemo {
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Inside FinalizeDemo's finalize()");
        } catch (Throwable e) {
            throw e;
        } finally {
            System.out.println("Calling finalize method of the Object class");
            super.finalize();
        }
    }
}
