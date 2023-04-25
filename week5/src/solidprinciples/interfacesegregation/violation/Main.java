package solidprinciples.interfacesegregation.violation;

import java.util.List;

class Main {
    public static void main(String[] args) {
        AreaCalculator areaCalculator = new AreaCalculator();
        ShapePrinter shapePrinter = new ShapePrinter(areaCalculator);
        Circle circle = new Circle(10);
        Square square = new Square(10);
        List<Shape> shapes = List.of(circle, square);
        int sum = areaCalculator.sum(shapes);
      
        //violation
        System.out.println("volume: " + circle.volume());
        
        System.out.println("area : " + sum);
        System.out.println(shapePrinter.json(shapes));
    }
}
