package edu.hillel.coffee.order;

import lombok.Value;

/**
 * order.
 */
@Value
public class Order {
  int orderNumber;
  String clientName;
}
