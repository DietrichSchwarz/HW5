package edu.hillel.repo;

import edu.hillel.dto.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepository {
  List<Order> orders;

  public OrderRepository() {
    this.orders = new ArrayList<>();
  }

  public Order addOrder(Order order) {
    orders.add(order);
    return order;
  }

  public Order getOrderById(UUID id) {
    for (Order order : orders) {
      if (order.getId().equals(id)) {
        return order;
      }
    }
    return null;
  }

  public List<Order> getAllOrders() {
    return orders;
  }
}