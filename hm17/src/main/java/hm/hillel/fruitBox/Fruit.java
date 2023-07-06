package edu.hillel.fruitBox;

import lombok.Data;

@Data
public abstract class Fruit {
  private final String name;
  private final float weight;
}