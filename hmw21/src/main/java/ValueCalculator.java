package edu.hillel;

import java.util.Arrays;

public class ValueCalculator {

  private final double[] array;
  private final int size;
  private final int halfSize;

  public ValueCalculator(int size) {
    int minSize = 1000000;
    if (size < minSize) {
      size = minSize;
    }
    this.size = size;
    this.halfSize = size / 2;
    this.array = new double[size];
  }

  public void calculate() {
    long start = System.currentTimeMillis();
    Arrays.fill(array, 1.0);

    double[] firstHalf = Arrays.copyOfRange(array, 0, halfSize);
    double[] secondHalf = Arrays.copyOfRange(array, halfSize, size);

    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < firstHalf.length; i++) {
        firstHalf[i] = (firstHalf[i] * Math.sin(0.2f + i * 1.0 / 5) * Math.cos(0.2f + i * 1.0 / 5)
            * Math.cos(0.4f + i * 1.0 / 2));
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < secondHalf.length; i++) {
        secondHalf[i] = (secondHalf[i] * Math.sin(0.2f + i * 1.0 / 5) * Math.cos(0.2f + i * 1.0 / 5)
            * Math.cos(0.4f + i * 1.0 / 2));
      }
    });

    thread1.start();
    thread2.start();

    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.arraycopy(firstHalf, 0, array, 0, halfSize);
    System.arraycopy(secondHalf, 0, array, halfSize, halfSize);

    long end = System.currentTimeMillis();
    System.out.println("Time elapsed = " + (end - start) + " ms");
  }
}