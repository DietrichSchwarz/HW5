package logger;

import edu.hillel.logger.AbstractLogger;
import edu.hillel.logger.LoggingLevel;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AbstractLoggerTest {
  @Data
  class MockLogger extends AbstractLogger {

    private LoggingLevel level;
    private String message;

    @Override
    public void log(LoggingLevel level, String message) {
      this.level = level;
      this.message = message;
    }
  }

  @Test
  void testInfo() {
    MockLogger logger = new MockLogger();
    String message = "Test info message";

    logger.info(message);

    Assertions.assertEquals(LoggingLevel.INFO, logger.getLevel());
    Assertions.assertEquals(message, logger.getMessage());
  }

  @Test
  void testDebug() {
    MockLogger logger = new MockLogger();
    String message = "Test debug message";

    logger.debug(message);

    Assertions.assertEquals(LoggingLevel.DEBUG, logger.getLevel());
    Assertions.assertEquals(message, logger.getMessage());
  }

  @Test
  void testGetFormattedMessage() {
    MockLogger logger = new MockLogger();
    LoggingLevel level = LoggingLevel.INFO;
    String message = "Test message";

    String actual = logger.getFormattedMessage(level, message);

    Assertions.assertTrue((actual.contains(message)));
  }
}