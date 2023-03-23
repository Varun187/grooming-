import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*1.	Write a program to accept two numbers as command line arguments and print the addition of those numbers. */

public class Addition {

    /* method 1 */

    // public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);
    // System.out.println("Enter the number of integers to add");
    // int n = scanner.nextInt();
    // int sum = 0;
    // for(int i = 0;i<n;i++)
    // {
    // System.out.println("please enter next integer");
    // sum += scanner.nextInt();
    // }
    // System.out.println("The sum of the integers are " + sum);
    // scanner.close();
    // }

    /* method 2 */

    // public static void main(String[] args) throws NumberFormatException,
    // IOException {
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // System.out.println("Enter the number of integers to add");
    // int n = Integer.parseInt(br.readLine());
    // int sum = 0;
    // for (int i = 0; i < n; i++) {
    // System.out.println("please enter next integer");
    // sum += Integer.parseInt(br.readLine());
    // }
    // System.out.println("The sum of the integers are " + sum);
    // }

    /* method 3 */
    public static void main(String[] args) {
        int sum = 0;
        System.out.println("Calculating Sum for below Integers");

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
            try {
                sum = sum + Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer command line arguments: " +
                        e.toString());
            }
        }
        System.out.println("Sum :" + sum);

    }

}
