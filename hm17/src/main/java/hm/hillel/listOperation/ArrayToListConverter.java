package edu.hillel.listOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayToListConverter {

  public static <T> List<T> toList(T[] array) {
    List<T> list = new ArrayList<>();
    Collections.addAll(list, array);
    return list;
  }
}