public class Square extends Shape {

    private final int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public void calculateArea() {
        setArea((int) Math.pow(side, 2));
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(4 * side);
    }
}
