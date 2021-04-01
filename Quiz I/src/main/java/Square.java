public class Square extends Shape {

    private double length;

    public Square(double length) {
        this.length = length;
    }

    public double computePerimeter() {
        return 4 * this.length;
    }

    public double computeArea() {
        return this.length * this.length;
    }
}