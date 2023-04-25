package solidprinciples.interfacesegregation.solution;

import java.util.List;

// responsibility - kind of displaying shapes in some format
class ShapePrinter {

    private final AreaCalculator areaCalculator;

    public ShapePrinter(AreaCalculator areaCalculator) {
        this.areaCalculator = areaCalculator;
    }

    public String json(List<Shape> shapes) {
        return String.format("{shapesSum: %d}", areaCalculator.sum(shapes));
    }

    public String csv(List<Shape> shapes) {
        return String.format("shapes_sum,%s", areaCalculator.sum(shapes));
    }
}
