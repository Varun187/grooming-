package solidprinciples.dependencyinversion;

public class Cube implements Shape, ThreeDimensionalShape{
    // some dummy logic
    private int side;

    public Cube(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        //fake implementation
       return 100;
    }

    @Override
    public double volume() {
        // fake implementation
       return 1000;
    }
}
