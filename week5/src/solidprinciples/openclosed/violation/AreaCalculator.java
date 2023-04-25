package solidprinciples.openclosed.violation;

import java.util.List;

// responsibility -  calculate some measurent of object
class AreaCalculator {
    
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

            // for we new shape we have change the code - not closed for modification
            if (shape instanceof Cube) {
                //some logic
            }

        }
        return sum;
    }
}
