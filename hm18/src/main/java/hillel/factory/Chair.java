package edu.hillel.factory;

public class Chair extends Furniture {
  @Override
  public void create() {
    System.out.println("Create a chair");
  }
}
