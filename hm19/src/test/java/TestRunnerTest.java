
import ExampleSuites.ExampleSuite01Test;
import ExampleSuites.ExampleSuite02Test;
import edu.hillel.TestRunner;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRunnerTest {

  @SneakyThrows
  @Test
  void startTest() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    TestRunner.start(ExampleSuite01Test.class);

    Assertions.assertTrue(outContent.toString().contains("BeforeSuite"));
    Assertions.assertTrue(outContent.toString().contains("TestMethod1"));
    Assertions.assertTrue(outContent.toString().contains("TestMethod2"));
    Assertions.assertTrue(outContent.toString().contains("TestMethod3"));
    Assertions.assertTrue(outContent.toString().contains("AfterSuite"));
  }

  @Test
  void startTest_doubleBeforeSuite() {
    Assertions.assertThrows(RuntimeException.class,
        () -> TestRunner.start(ExampleSuite02Test.class));
  }
}