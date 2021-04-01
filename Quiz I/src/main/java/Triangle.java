public class Triangle extends Shape {

    private double length1;
    private double length2;
    private double length3;


    public Triangle(double length1, double length2, double length3) {
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
    }

    public double computePerimeter() {
        return this.length1 + this.length2 +this.length3;
    }

    public double computeArea() {
        double semiP = computePerimeter() / 2;
        return Math.sqrt(semiP * (semiP - length1) * (semiP - length2) * (semiP - length3)) ;
    }
}
