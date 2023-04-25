package solidprinciples.dependencyinversion;

import java.util.List;

class Main {
    public static void main(String[] args) {
        // using modern calutator here
        IAreaCalculator areaCalculator = new AreaCalculatorModern();
        ShapePrinter shapePrinter = new ShapePrinter(areaCalculator);

        Circle circle = new Circle(10);
        Square square = new Square(10);
        Cube cube = new Cube(3);

        List<Shape> shapes = List.of(circle, square);
        int sum = areaCalculator.sum(shapes);
        System.out.println("area : " + sum);

        System.out.println(shapePrinter.json(shapes));

        // volume supported onlt for three dimensional shapes
        System.out.println("volume: " + cube.volume());
    }
}
