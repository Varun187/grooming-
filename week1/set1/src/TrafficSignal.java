import java.util.Scanner;

/*Program to convert string to enum */

public enum TrafficSignal {
    RED("STOP"), YELLOW("WAIT"), GREEN("MOVE");
    private String signal;

    private TrafficSignal(String signal){
        this.signal = signal;
    }

    public String getSignal() {
        return signal;
    }
}

class Solution{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the color code for which the traffic action to be known?");
        String signal = scanner.next();
        scanner.close();
        System.out.println("The color is: " + TrafficSignal.valueOf(signal.toUpperCase()));
        System.out.println("The action is: " + TrafficSignal.valueOf(signal.toUpperCase()).getSignal());
    }
}
