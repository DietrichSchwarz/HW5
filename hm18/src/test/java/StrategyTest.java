import edu.hillel.strategy.Rectangle;
import edu.hillel.strategy.Shape;
import edu.hillel.strategy.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StrategyTest {

  @Test
  void strategyTest() {
    Shape rectangle = new Shape(new Rectangle(10,5));
    Shape triangle = new Shape(new Triangle(6,8));

    Assertions.assertEquals(rectangle.calculateArea(), 50.0);
    Assertions.assertEquals(triangle.calculateArea(), 24.0);
  }
}