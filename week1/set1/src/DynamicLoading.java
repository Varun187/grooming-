import java.util.Scanner;

public class DynamicLoading {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Enter the classname of type shape for which the area has to be calculated: ");
        Scanner scanner = new Scanner(System.in);
        try {
            String className = scanner.next();
            Class<?> obj = Class.forName(className);
            java.lang.reflect.Constructor<?> constructor = obj.getDeclaredConstructor();
            Shape shape = (Shape)constructor.newInstance();
            shape.area(5, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            scanner.close();
        }
    }
}