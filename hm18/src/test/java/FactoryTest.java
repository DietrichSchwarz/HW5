import edu.hillel.factory.Chair;
import edu.hillel.factory.FurnitureFactory;
import edu.hillel.factory.Sofa;
import edu.hillel.factory.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactoryTest {

  @Test
  void factoryTest() {
    FurnitureFactory factory = new FurnitureFactory();
    Assertions.assertEquals(Chair.class, factory.createFurniture("chair").getClass());
    Assertions.assertEquals(Sofa.class, factory.createFurniture("sofa").getClass());
    Assertions.assertEquals(Table.class, factory.createFurniture("table").getClass());
    Assertions.assertNull(factory.createFurniture("book"));
  }
}
