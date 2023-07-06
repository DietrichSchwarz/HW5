package edu.hillel;

import static java.lang.Thread.sleep;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Semaphore;

public class PetrolStation {
  private int amount;
  private final Semaphore semaphore;
  private final Map<UUID, Integer> reservedFuel;

  public PetrolStation(int amount, int queue) {
    this.amount = amount;
    this.semaphore = new Semaphore(queue);
    this.reservedFuel = new HashMap<>();
  }

  public void doRefuel(int amount) {
    UUID operationId = UUID.randomUUID();
    if (!reserveFuel(operationId, amount)) {
      System.out.println("Not enough fuel on the station. Refuelling aborted. Now available "
          + getAvailableAmount());
      return;
    }
    try {
      semaphore.acquire();

      System.out.println("Starting refuelling...");
      sleep((long) (Math.random() * 7000 + 3000));

      refuel(operationId);
      System.out.println(
          "Refuelling completed. Remaining fuel on the station: " + getAvailableAmount());

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      semaphore.release();
    }
  }

  private synchronized boolean reserveFuel(UUID operationId, int reservedAmount) {
    if (getAvailableAmount() - reservedAmount >= 0) {
      reservedFuel.put(operationId, reservedAmount);
      return true;
    }
    return false;
  }

  private synchronized void refuel(UUID operationId) {
    amount -= reservedFuel.get(operationId);
    reservedFuel.remove(operationId);
  }

  private synchronized int getAvailableAmount() {
    return amount - reservedFuel.values().stream().reduce(0, Integer::sum);
  }
}