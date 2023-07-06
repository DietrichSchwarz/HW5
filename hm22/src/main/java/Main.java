package edu.hillel;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  public static void main(String[] args) {

    //ThreadSafeList
    ThreadSafeList<String> list = new ThreadSafeList<>();
    String s = "String";
    new Thread(() -> {
      list.add(s);
      System.out.println("add() = " + Arrays.toString(list.getList().toArray()));
    }).start();
    new Thread(() -> {
      System.out.println("get() = " + list.get(0));
    }).start();
    new Thread(() -> {
      System.out.println("before remove() = " + Arrays.toString(list.getList().toArray()));
      list.remove(s);
      System.out.println("after remove() = " + Arrays.toString(list.getList().toArray()));
    }).start();


    //PetrolStation
    PetrolStation petrolStation = new PetrolStation(20, 3);
    ExecutorService executor = Executors.newFixedThreadPool(4);

    executor.execute(() -> petrolStation.doRefuel(7));
    executor.execute(() -> petrolStation.doRefuel(3));
    executor.execute(() -> petrolStation.doRefuel(2));
    executor.execute(() -> petrolStation.doRefuel(4));
    executor.execute(() -> petrolStation.doRefuel(3));
    executor.execute(() -> petrolStation.doRefuel(4));

    executor.shutdown();
  }
}