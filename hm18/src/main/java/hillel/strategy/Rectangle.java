package edu.hillel.strategy;

import lombok.Value;

@Value
public class Rectangle implements AreaCalculator {
  double width;
  double height;

  @Override
  public double calculateArea() {
    return width * height;
  }
}