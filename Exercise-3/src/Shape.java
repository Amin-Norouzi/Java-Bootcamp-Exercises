public abstract class Shape {

    private int area;
    private int perimeter;

    protected Shape() {
    }

    public void calculateArea() {}

    public void calculatePerimeter() {}

    public void showResults() {
        System.out.println("\nArea: " + area + "\nPerimeter: " + perimeter);
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }
}
