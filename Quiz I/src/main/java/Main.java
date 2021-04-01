public class Main {

    public static void main(String args[]) {

        Canvas canvas = new Canvas();
        canvas.addShape(new Triangle(2,3,4));
        canvas.addShape(new Square(4));
        canvas.addShape(new Circle(7));
        canvas.addShape(new Rectangle(2.5, 6));
        canvas.draw();

        canvas.addShape(new Triangle(2 ,4 , 6));
        canvas.addShape(new Square(5));
    }

}
