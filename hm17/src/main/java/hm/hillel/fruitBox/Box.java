package edu.hillel.fruitBox;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Box<T extends Fruit> {
  private float weight;
  private final List<T> fruits;

  public Box() {
    this.weight = 0;
    this.fruits = new ArrayList<>();
  }

  public void add(T fruit) {
    if (fruits.isEmpty() || fruits.get(0).getClass().equals(fruit.getClass())) {
      fruits.add(fruit);
    } else {
      System.out.println("Cannot add fruit of different type to the box");
    }
  }

  public void add(List<T> newFruits) {
    for (T fruit : newFruits) {
      add(fruit);
    }
  }

  public float getWeight() {
    for (T fruit : fruits) {
      weight += fruit.getWeight();
    }
    return weight;
  }

  public boolean compare(Box<?> box) {
    return this.getWeight() == box.getWeight();
  }

  public void merge(Box<T> box) {
    if (fruits.size() == 0 || box.fruits.size() == 0) {
      return;
    }

    if (fruits.get(0).getClass() == box.fruits.get(0).getClass()) {
      fruits.addAll(box.fruits);
      box.fruits.clear();
    } else {
      System.out.println("It is not possible to combine boxes with different types of fruit");
    }
  }
}