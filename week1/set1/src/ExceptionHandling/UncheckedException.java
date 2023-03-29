package ExceptionHandling;

/*runtime exception. These are exceptional conditions that are internal to the application, and that the application usually cannot anticipate or
 recover from. These usually indicate programming bugs, such as logic errors or improper use of an API 
 The application can catch this exception, but it probably makes more sense to eliminate the bug that caused the exception to occur.
 */
import java.util.Scanner;

public class UncheckedException {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number x: ");
        int x = scanner.nextInt();
        System.out.println("Enter second number y: ");
        int y = scanner.nextInt();
        
        // int z = x / y; // this might throw an run time exception if the value of y is 0 since it is mathematically incorrect to divide by zero gives infinity
        
        while(y==0){
            // throw new ArithmeticException("The value of second no can't be zero. Please enter again y: ");
            System.out.println("The value of second no can't be zero. Please enter again y: ");
            y = scanner.nextInt();
        }
        int z = x/y;
        System.out.println("result of x/y: " + z);
        scanner.close();
    }

}
