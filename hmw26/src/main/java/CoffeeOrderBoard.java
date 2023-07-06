package edu.hillel.coffee.order;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * order queue.
 */
@Data
@Log4j2
public class CoffeeOrderBoard {
  Queue<Order> orders;
  int orderNumber;

  public CoffeeOrderBoard() {
    this.orders = new LinkedList<>();
    orderNumber = 1;
  }

  public void add(String clientName) {
    log.info("Adding order for client: " + clientName);
    orders.add(new Order(orderNumber, clientName));
    orderNumber++;
  }

  /**
   * gives out the nearest order.
   */
  public void deliver() {
    if (!orders.isEmpty()) {
      Order order = orders.poll();
      log.info("Delivering order #" + order.getOrderNumber() + " for " + order.getClientName());
    } else {
      log.warn("No orders in queue!");
    }
  }

  /**
   * issues an order by number.
   */
  public void deliver(int orderNumber) {
    log.info("Delivering order #" + orderNumber);
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
      log.info("Delivering order #" + order.getOrderNumber() + " for " + order.getClientName());
    } else {
      log.error("Order #" + orderNumber + " not found!");
    }
  }

  /**
   * current queue in console.
   */
  public void draw() {
    log.info("Current queue:");
    for (Order order : orders) {
      System.out.println(order.getOrderNumber() + " | " + order.getClientName());
    }
  }
}