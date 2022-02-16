public class Circle extends Shape {

    private static final double PI = 3.14;
    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        setArea((int) (PI * Math.pow(radius, 2)));
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter((int) (2 * PI * radius));
    }
}
