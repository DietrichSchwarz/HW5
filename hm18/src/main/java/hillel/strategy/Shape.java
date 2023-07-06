package edu.hillel.strategy;

import lombok.Value;

@Value
public class Shape {
  AreaCalculator areaCalculator;

  public double calculateArea() {
    return areaCalculator.calculateArea();
  }
}