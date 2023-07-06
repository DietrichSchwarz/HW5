package edu.hillel.strategy;

import lombok.Value;

@Value
public class Triangle implements AreaCalculator {
  double base;
  double height;

  @Override
  public double calculateArea() {
    return 0.5 * base * height;
  }
}