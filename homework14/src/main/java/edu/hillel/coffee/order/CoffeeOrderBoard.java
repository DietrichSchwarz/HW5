package edu.hillel.coffee.order;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import lombok.Data;

/**
 * order queue.
 */
@Data
public class CoffeeOrderBoard {
  Queue<Order> orders;
  int orderNumber;

  public CoffeeOrderBoard() {
    this.orders = new LinkedList<>();
    orderNumber = 1;
  }

  public void add(String clientName) {
    orders.add(new Order(orderNumber, clientName));
    orderNumber++;
  }

  /**
   * gives out the nearest order.
   */
  public void deliver() {
    if (!orders.isEmpty()) {
      Order order = orders.poll();
      System.out.println(
          "Delivering order #" + order.getOrderNumber() + " for " + order.getClientName());
    } else {
      System.out.println("No orders in queue!");
    }
  }

  /**
   * issues an order by number.
   */
  public void deliver(int orderNumber) {
    Order order = null;
    Iterator<Order> iterator = orders.iterator();

    while (iterator.hasNext()) {
      Order o = iterator.next();
      if (o.getOrderNumber() == orderNumber) {
        order = o;
        iterator.remove();
        break;
      }
    }

    if (order != null) {
      System.out.println(
          "Delivering order #" + order.getOrderNumber() + " for " + order.getClientName());
    } else {
      System.out.println("Order #" + orderNumber + " not found!");
    }
  }

  /**
   * current queue in console.
   */
  public void draw() {
    for (Order order : orders) {
      System.out.println(order.getOrderNumber() + " | " + order.getClientName());
    }
  }
}