package edu.hillel.builder;


public class CarBuilderImpl implements CarBuilder {
  private String engine;
  private String transmission;
  private String wheels;
  private String color;

  @Override
  public CarBuilder buildEngine(String engine) {
    this.engine = engine;
    return this;
  }

  @Override
  public CarBuilder buildTransmission(String transmission) {
    this.transmission = transmission;
    return this;
  }

  @Override
  public CarBuilder buildWheels(String wheels) {
    this.wheels = wheels;
    return this;
  }

  @Override
  public CarBuilder buildColor(String color) {
    this.color = color;
    return this;
  }

  @Override
  public Car getCar() {
    return new Car(engine, transmission, wheels, color);
  }
}