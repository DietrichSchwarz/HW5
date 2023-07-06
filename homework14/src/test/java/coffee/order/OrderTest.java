package coffee.order;

import edu.hillel.coffee.order.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {

  @Test
  void testOrderConstructor() {
    Order order = new Order(1, "client");

    Assertions.assertEquals(1, order.getOrderNumber());
    Assertions.assertEquals("client", order.getClientName());
  }
}