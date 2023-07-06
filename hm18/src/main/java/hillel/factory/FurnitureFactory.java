package edu.hillel.factory;

public class FurnitureFactory {
  public Furniture createFurniture(String type) {
    switch (type) {
      case "chair":
        return new Chair();
      case "sofa":
        return new Sofa();
      case "table":
        return new Table();
      default:
        return null;
    }
  }
}
