package solidprinciples.interfacesegregation.violation;

class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return Math.pow(getSide(), 2);
    }

    @Override
    public double volume() {
        throw new UnsupportedOperationException("Unimplemented method 'volume'");
    }

}
