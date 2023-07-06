package edu.hillel.figures;

public class Triangle implements Figure {
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getSquare() {
        double perimeter = (side1 + side2 + side3) / 2.0d;
        return Math.sqrt(perimeter * (perimeter - side1) * (perimeter - side2) * (perimeter - side3));
    }
}