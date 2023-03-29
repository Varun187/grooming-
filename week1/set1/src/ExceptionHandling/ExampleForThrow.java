package ExceptionHandling;

public class ExampleForThrow {
    public static void main(String[] args) {
        validateAge(10);
    }

    public static void validateAge(int age) {
        if (age < 18) {
            throw new AgeNotSuffientException("Age not suffient for voting");
        } else {
            System.out.println("Eligible for voting");
        }
    }
}
