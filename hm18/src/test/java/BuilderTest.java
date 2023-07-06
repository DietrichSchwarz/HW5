import edu.hillel.builder.CarBuilder;
import edu.hillel.builder.CarBuilderImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuilderTest {

  @Test
  void builderTest() {
    CarBuilder carBuilder = new CarBuilderImpl();

    carBuilder
        .buildEngine("V8")
        .buildTransmission("Automatic")
        .buildWheels("18-inch")
        .buildColor("Black");

    Assertions.assertEquals("V8", carBuilder.getCar().getEngine());
    Assertions.assertEquals("Automatic", carBuilder.getCar().getTransmission());
    Assertions.assertEquals("18-inch", carBuilder.getCar().getWheels());
    Assertions.assertEquals("Black", carBuilder.getCar().getColor());

  }
}