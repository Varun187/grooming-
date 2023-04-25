package solidprinciples.dependencyinversion;

import java.util.List;

public class AreaCalculatorModern implements IAreaCalculator {

    @Override
    public int sum(List<Shape> shapes) {
        // new logic - fake implementation
        return 450;
    }

}
