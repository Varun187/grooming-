public class StaticExamples {
    public static void main(String[] args) {

        Test test = new Test(5);
        System.out.println("Value of a : " + Test.a);
        System.out.println("Value of a : " + test.getB());

        // calling static method without creating any object of class. Members can be
        // accessed before instantiating a class
        Test.display();
    }
}


class Test {
    static int a = 10;
    private int b;

    public Test(int b){
        System.out.println("constructor of test called");
        this.b = b;
    }

    static {
        System.out.println("Static block called.");
        // Cannot make a static reference to the non-static field b
        /*b = 10; */                     // compilation error

        // Cannot make a static reference to the
        // non-static method m2() from the type Test
        /* getB(); */                                // compilation error

    }

    static void display() {
        System.out.println("from static method display");
    }

    public int getB(){
        return this.b;
    }

    public static void main(String[] args) {
        System.out.println("from main of test class");
    }
}
