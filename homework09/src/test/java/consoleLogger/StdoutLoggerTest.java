package consoleLogger;

import edu.hillel.consoleLogger.StdoutLogger;
import edu.hillel.consoleLogger.StdoutLoggerConfiguration;
import edu.hillel.logger.LoggingLevel;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StdoutLoggerTest {

  @Test
  void testStdoutLoggerConstructor() {
    StdoutLoggerConfiguration config = new StdoutLoggerConfiguration(LoggingLevel.INFO);
    StdoutLogger logger = new StdoutLogger(config);
    Assertions.assertNotNull(logger);
  }

  @Test
  void testLog() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    StdoutLogger logger = new StdoutLogger(new StdoutLoggerConfiguration(LoggingLevel.INFO));
    logger.info("test info");
    Assertions.assertTrue((outContent.toString().contains("test info")));

    logger = new StdoutLogger(new StdoutLoggerConfiguration(LoggingLevel.DEBUG));
    logger.debug("test debug");
    Assertions.assertTrue((outContent.toString().contains("test debug")));
  }
}