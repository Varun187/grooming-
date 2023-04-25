package solidprinciples.singleresponsibility.violation;

import java.util.List;

// violates single responsibility
class AreaCalculator {
    // responsibility -  calculate some measurent of object
    public int sum(List<Object> shapes) {
        int sum = 0;
        for (int i = 0; i < shapes.size(); i++) {
            Object shape = shapes.get(i);
            if (shape instanceof Square) {
                sum += Math.pow(((Square) shape).getSide(), 2);
            }
            if (shape instanceof Circle) {
                sum += Math.PI + Math.pow(((Circle) shape).getRadius(), 2);
            }
        }
        return sum;
    }

    //responsibility - kind of displaying shapes in some format
    public String json(List<Object> shapes) {
        return String.format("{shapesSum: %d}", sum(shapes));
    }

    public String csv(List<Object> shapes) {
        return String.format("shapes_sum,%s", sum(shapes));
    }
}
