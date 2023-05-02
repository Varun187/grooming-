package designpatterns.structural.bridge.color;

//abstraction
public abstract class Shape {
    protected Color color;

    // constructor with implementor as input argument
    public Shape(Color c) {
        this.color = c;
    }

    abstract public void applyColor();
}
