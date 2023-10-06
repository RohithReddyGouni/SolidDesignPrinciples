package openclosedprinciple;


import java.util.ArrayList;
import java.util.List;

// Define an abstract base class for shapes
abstract class Shape {
    abstract double calculateArea();
}

// Concrete classes for different shapes
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// A class that operates on a list of shapes without modification
class ShapeCalculator {
    public double calculateTotalArea(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        // Create a list of shapes
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(5, 10));
        shapes.add(new Circle(3));

        // Calculate the total area of shapes without modifying the ShapeCalculator class
        ShapeCalculator calculator = new ShapeCalculator();
        double totalArea = calculator.calculateTotalArea(shapes);

        System.out.println("Total Area of Shapes: " + totalArea);
    }
}
