
public class Shape {
    sealed interface ShapeInterface permits Circle, Rectangle, Triangle {}

    record Circle(double radius) implements ShapeInterface {}
    record Rectangle(double width, double height) implements ShapeInterface {}
    record Triangle(double base, double height) implements ShapeInterface {}

    public static double calculateArea(ShapeInterface shape) {
        return switch (shape) {
            case Circle c -> Math.PI * c.radius() * c.radius();
            case Rectangle r -> r.width() * r.height();
            case Triangle t -> 0.5 * t.base() * t.height();
        };
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);
        Triangle triangle = new Triangle(3, 4);

        System.out.println("Circle area: " + calculateArea(circle));
        System.out.println("Rectangle area: " + calculateArea(rectangle));
        System.out.println("Triangle area: " + calculateArea(triangle));
    }
}
