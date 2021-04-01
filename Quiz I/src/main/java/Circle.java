public class Circle extends Shape {

    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double computePerimeter() {
        return 2 * Math.PI * this.radius ;
    }

    public double computeArea() {
        return  Math.PI * this.radius * this.radius;
    }
}
