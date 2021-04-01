import java.util.ArrayList;
import java.util.List;

public class Canvas {

    List<Shape> shapes;
    private boolean hasCircle;
    private boolean hasSquare;
    private boolean hasRectangle;
    private boolean hasTriangle;

    public Canvas() {
        shapes = new ArrayList<Shape>();
        hasCircle = false;
        hasSquare = false;
        hasRectangle = false;
        hasTriangle = false;
    }

    public void addShape(Shape shape) {
        boolean duplicate = hasDuplicate(shape);
        if (! duplicate ) {
            this.shapes.add(shape);
        }
    }

    public void draw() {
        double perimeter = 0;
        double area = 0;
        for (Shape shape: this.shapes) {
            perimeter += shape.computePerimeter();
            area += shape.computeArea();

        }
        System.out.println("total perimeter: " + perimeter);
        System.out.println("total area: " + area);
    }

    public boolean hasDuplicate(Shape shape) {
        if (shape instanceof Circle && ! this.hasCircle) {
            this.hasCircle = true;
            return false;
        }

        if (shape instanceof Square && ! this.hasSquare) {
            this.hasSquare = true;
            return false;
        }

        if (shape instanceof Rectangle && ! this.hasRectangle) {
            this.hasRectangle = true;
            return false;
        }

        if (shape instanceof Triangle && !this.hasTriangle ) {
            this.hasTriangle = true;
            return false;
        }

        duplicateError(shape);
        return true;

    }

    public void duplicateError(Shape s) {
        System.out.println("Duplicate of: " + s.getClass());
    }

}