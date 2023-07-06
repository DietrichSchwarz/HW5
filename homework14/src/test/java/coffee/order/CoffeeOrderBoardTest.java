package coffee.order;

import edu.hillel.coffee.order.CoffeeOrderBoard;
import edu.hillel.coffee.order.Order;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeOrderBoardTest {

  //CoffeeOrderBoard
  @Test
  void testCoffeeOrderBoardConstructor() {
    CoffeeOrderBoard board = new CoffeeOrderBoard();

    Assertions.assertTrue(board.getOrders().isEmpty());
  }

  //add
  @Test
  void testAdd() {
    CoffeeOrderBoard board = new CoffeeOrderBoard();
    Order order = new Order(2, "Jane");
    board.add("John");
    board.add("Jane");
    board.add("Bob");

    Assertions.assertEquals(3, board.getOrders().size());
    Assertions.assertTrue(board.getOrders().contains(order));
  }

  //deliver
  @Test
  void testDeliverIsEmpty() {
    CoffeeOrderBoard board = new CoffeeOrderBoard();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    board.deliver();

    Assertions.assertTrue(outContent.toString().contains("No orders in queue!"));
  }

  @Test
  void testDeliverFirstElement() {
    CoffeeOrderBoard board = new CoffeeOrderBoard();
    board.add("John");
    board.add("Jane");
    board.add("Bob");

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    board.deliver();

    Assertions.assertTrue(outContent.toString().contains("Delivering order #1 for John"));
  }

  @Test
  void testDeliverNextElement() {
    CoffeeOrderBoard board = new CoffeeOrderBoard();
    board.add("John");
    board.add("Jane");
    board.add("Bob");

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    board.deliver();
    outContent.reset();
    System.setOut(new PrintStream(outContent));
    board.deliver();

    Assertions.assertTrue(outContent.toString().contains("Delivering order #2 for Jane"));
  }


  //deliver with orderNumber
  @Test
  void testDeliverOrderFound() {
    CoffeeOrderBoard board = new CoffeeOrderBoard();
    board.add("John");
    board.add("Jane");
    board.add("Bob");
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    board.deliver(2);

    Assertions.assertTrue(outContent.toString().contains("Delivering order #2 for Jane"));
  }

  @Test
  void testDeliverOrderNotFound() {
    CoffeeOrderBoard board = new CoffeeOrderBoard();
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    board.deliver(2);

    Assertions.assertTrue(outContent.toString().contains("Order #2 not found!"));
  }

  //draw
  @Test
  void testDraw() {
    CoffeeOrderBoard board = new CoffeeOrderBoard();
    board.add("John");
    board.add("Jane");
    board.add("Bob");
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    board.deliver(2);

    outContent.reset();
    System.setOut(new PrintStream(outContent));
    board.draw();

    Assertions.assertTrue(outContent.toString().contains("1 | John"));
    Assertions.assertTrue(outContent.toString().contains("3 | Bob"));
  }
}