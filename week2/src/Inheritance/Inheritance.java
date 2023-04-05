package Inheritance;

//program to understand inheritance and overriding in java together
public class Inheritance {
    public static void main(String[] args) {
        A a = new A();
        A b1 = new B();
        B b2 = new B();
        
        a.display(3);
        a.display(Integer.valueOf(3));


        b1.display(3);
        b1.display(Integer.valueOf(3));

        b2.display(3);
        b2.display(Integer.valueOf(3));

        System.out.println(a.value);
        System.out.println(b1.value);
        System.out.println(b2.value);

        a.info();
        b1.info();
        b2.info();
    }

    
}

class A{
    int value = 10;
    public void display(int a){
        System.out.println("A is called");
    }

    public void info(){
        System.out.println("info from A");
    }

    // public void display(Integer a) {
    //     System.out.println("A is called");
    // }
}

class B extends A{
    int value = 5;
    public void display(Integer a) {
        System.out.println("B is called");
    }

    public void info() {
        System.out.println("info from B");
    }

    // public void display(int a) {
    //     System.out.println("B is called");
    // }
}
