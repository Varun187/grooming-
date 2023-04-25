package solidprinciples.openclosed.violation;

import java.util.List;

// responsibility - kind of displaying shapes in some format
class ShapePrinter {

    private final AreaCalculator areaCalculator;

    public ShapePrinter(AreaCalculator areaCalculator) {
        this.areaCalculator = areaCalculator;
    }
  
    public String json(List<Object> shapes) {
        return String.format("{shapesSum: %d}", areaCalculator.sum(shapes));
    }

    public String csv(List<Object> shapes) {
        return String.format("shapes_sum,%s", areaCalculator.sum(shapes));
    }
}
