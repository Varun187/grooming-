package designpatterns.structural.bridge.color;

public class Rectangle extends Shape {

    public Rectangle(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Rectangle filled with color ");
        color.applyColor();
    }

}
