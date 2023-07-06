package edu.hillel.figures;

public class Circle implements Figure {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * 2 * radius;
    }
}