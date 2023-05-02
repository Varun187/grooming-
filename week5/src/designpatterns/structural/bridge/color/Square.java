package designpatterns.structural.bridge.color;

public class Square extends Shape{
    public Square(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Square filled with color ");
        color.applyColor();
    }
}
