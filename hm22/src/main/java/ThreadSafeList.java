package edu.hillel;

import java.util.concurrent.CopyOnWriteArrayList;
import lombok.Data;

@Data
public class ThreadSafeList<T> {
  private final CopyOnWriteArrayList<T> list;

  public ThreadSafeList() {
    list = new CopyOnWriteArrayList<>();
  }

  public void add(T element) {
    list.add(element);
  }

  public void remove(T element) {
    list.remove(element);
  }

  public T get(int index) {
    return list.get(index);
  }
}
