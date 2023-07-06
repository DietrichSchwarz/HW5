package edu.hillel.factory;

public class Table extends Furniture {
  @Override
  public void create() {
    System.out.println("Create a table");
  }
}