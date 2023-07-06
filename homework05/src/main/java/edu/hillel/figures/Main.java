package edu.hillel.figures;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Figure> figuresList = new ArrayList<>();
        figuresList.add(new Circle(11.5));
        figuresList.add(new Circle(5.25));
        figuresList.add(new Square(4));
        figuresList.add(new Square(6.25));
        figuresList.add(new Triangle(4, 5, 6));
        figuresList.add(new Triangle(1, 2, 3));
        figuresList.add(new Triangle(2.25, 5.25, 7.25));

        double squareSum = 0;
        for (Figure figure : figuresList) {
            squareSum += figure.getSquare();
        }
        System.out.println("Total square = " + squareSum);
    }
}

