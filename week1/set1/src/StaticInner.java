class OuterClass {

    private static String greeting = "Welcomes you all";
    final String NAME = "Outer class";

    public static class NestedStaticClass {

        // Only static members of Outer class is directly accessible in nested static class
        public void display() {
            System.out.println("Message from nested static class: " + greeting);
            /* System.out.println(NAME); */ // there will be compiler error
        }
    }

    public class InnerClass {

        // Both static and non-static members of Outer class are accessible in this
        // Inner class
        public void display() {
            System.out.println("Message from non-static inner class: "+ NAME + greeting);
        }
    }
}

public class StaticInner {
    public static void main(String args[]) {

        OuterClass.NestedStaticClass nested = new OuterClass.NestedStaticClass();
        nested.display();

        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}
