public class Triangle extends Shape {

    private final int side1;
    private final int side2;
    private final int base;
    private final int height;

    public Triangle(int side1, int side2, int base, int height) {
        this.side1 = side1;
        this.side2 = side2;
        this.base = base;
        this.height = height;
    }

    @Override
    public void calculateArea() {
        setArea((base * height) / 2);
    }

    @Override
    public void calculatePerimeter() {
       setPerimeter(side1 + base + side2);
    }
}
