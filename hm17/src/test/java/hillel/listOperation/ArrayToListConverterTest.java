package edu.hillel.listOperation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ArrayToListConverterTest {

  @Test
  void toListTest() {
    String[] stringArray = {"foo", "bar", "baz"};
    List<String> expectedStringList = new ArrayList<>();
    expectedStringList.add(stringArray[0]);
    expectedStringList.add(stringArray[1]);
    expectedStringList.add(stringArray[2]);

    assertEquals(expectedStringList, ArrayToListConverter.toList(stringArray));

    Integer[] intArray = {1, 2, 3};
    List<Integer> expectedIntList = new ArrayList<>();
    expectedIntList.add(intArray[0]);
    expectedIntList.add(intArray[1]);
    expectedIntList.add(intArray[2]);

    assertEquals(expectedIntList, ArrayToListConverter.toList(intArray));
  }
}