package edu.hillel.factory;

public class Sofa extends Furniture {
  @Override
  public void create() {
    System.out.println("Create a sofa");
  }
}