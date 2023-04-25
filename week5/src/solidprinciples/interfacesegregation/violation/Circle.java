package solidprinciples.interfacesegregation.violation;

class Circle implements Shape{
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI + Math.pow(getRadius(), 2);
    }

    @Override
    public double volume() {
        throw new UnsupportedOperationException("Unimplemented method 'volume'");
    }

}
