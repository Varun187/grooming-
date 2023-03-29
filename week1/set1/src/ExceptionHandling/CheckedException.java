/*checked exception. These are exceptional conditions that a well-written application should anticipate and recover from
 *A well-written program will catch this exception and notify the user of the mistake, possibly prompting for a corrected response */
package ExceptionHandling;

import java.io.*;

public class CheckedException {
    public static void main(String[] args) {

        try (FileReader file = new FileReader("week1/set1/src/ExceptionHandling/file.txt")) {
            try (BufferedReader fileInput = new BufferedReader(file)) {
                String line;
                while ((line = fileInput.readLine()) != null)
                    System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Finnaly keyword mostly used for clean up code");
        }

        // or we can use throws clause
    }
}
