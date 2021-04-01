
public class Rectangle extends Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double computePerimeter() {
        return 2 * this.length + 2 * this.width;
    }

    public double computeArea() {
        return this.length * this.width;
    }
}