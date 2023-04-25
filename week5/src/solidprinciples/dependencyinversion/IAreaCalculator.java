package solidprinciples.dependencyinversion;

import java.util.List;

interface IAreaCalculator {
    public int sum(List<Shape> shapes);
}
