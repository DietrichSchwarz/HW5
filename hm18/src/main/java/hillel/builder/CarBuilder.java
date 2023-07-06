package edu.hillel.builder;

public interface CarBuilder {
  CarBuilder buildEngine(String engine);

  CarBuilder buildTransmission(String transmission);

  CarBuilder buildWheels(String wheels);

  CarBuilder buildColor(String color);

  Car getCar();
}