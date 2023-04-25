package solidprinciples.interfacesegregation.solution;

import java.util.List;

// responsibility -  calculate some measurent of object
class AreaCalculator {

    public int sum(List<Shape> shapes) {
        int sum = 0;
        for (int i = 0; i < shapes.size(); i++) {
            sum += shapes.get(i).area();
        }
        return sum;
    }
}
