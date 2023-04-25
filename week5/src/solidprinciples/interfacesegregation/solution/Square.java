package solidprinciples.interfacesegregation.solution;

class Square implements Shape{
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

}
