package edu.hillel.fruitBox;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class BoxTest {

  @Test
  void addTest() {
    Box<Apple> appleBox = new Box<>();
    Apple apple1 = new Apple();
    Apple apple2 = new Apple();
    Apple apple3 = new Apple();
    appleBox.add(apple1);
    appleBox.add(apple2);
    appleBox.add(apple3);
    List<Apple> expectedApples = Arrays.asList(apple1, apple2, apple3);

    assertEquals(expectedApples, appleBox.getFruits());
  }

  @Test
  void addListTest() {
    Box<Apple> appleBox = new Box<>();
    Apple apple1 = new Apple();
    Apple apple2 = new Apple();
    Apple apple3 = new Apple();
    List<Apple> expectedApples = Arrays.asList(apple1, apple2, apple3);
    appleBox.add(expectedApples);

    assertEquals(expectedApples, appleBox.getFruits());
  }

  @Test
  void getWeightTest() {
    Box<Apple> box1 = new Box<>();
    box1.add(new Apple());
    box1.add(new Apple());
    assertEquals(2.0f, box1.getWeight(), 0.001f);

    Box<Orange> box2 = new Box<>();
    box2.add(new Orange());
    box2.add(new Orange());
    box2.add(new Orange());
    assertEquals(4.5f, box2.getWeight(), 0.001f);
  }

  @Test
  void compareTest() {
    Box<Apple> appleBox1 = new Box<>();
    appleBox1.add(new Apple());
    appleBox1.add(new Apple());

    Box<Apple> appleBox2 = new Box<>();
    appleBox2.add(new Apple());
    appleBox2.add(new Apple());

    assertTrue(appleBox1.compare(appleBox2));

    Box<Apple> appleBox3 = new Box<>();
    appleBox3.add(new Apple());

    Box<Orange> orangeBox4 = new Box<>();
    orangeBox4.add(new Orange());

    assertFalse(appleBox2.compare(orangeBox4));
  }

  @Test
  void mergeTest() {
    Box<Apple> box1 = new Box<>();
    box1.add(new Apple());
    box1.add(new Apple());
    Box<Apple> box2 = new Box<>();
    box2.add(new Apple());

    box1.merge(box2);

    assertEquals(3, box1.getFruits().size());
    assertEquals(0, box2.getFruits().size());
  }
}