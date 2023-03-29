/*We can use throws keyword to give the responsibility of exception handling to the caller (It may be a method or JVM) 
then caller method is responsible to handle that exception */

package ExceptionHandling;

public class ThrowsExample {
    public static void main(String[] args) throws InterruptedException{
        Thread.sleep(3000);
        System.out.println("Hello world");
    }
}

