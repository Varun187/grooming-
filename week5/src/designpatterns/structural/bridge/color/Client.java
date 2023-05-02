package designpatterns.structural.bridge.color;

public class Client {
    public static void main(String[] args) {
        Shape square = new Square(new BlueColor());
        square.applyColor();

        Shape rectangle = new Rectangle(new GreenColor());
        rectangle.applyColor();
    }
}
