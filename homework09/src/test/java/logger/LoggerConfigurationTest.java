package logger;

import edu.hillel.logger.LoggerConfiguration;
import edu.hillel.logger.LoggingLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerConfigurationTest {
  @Test
  void testGetLogLevel() {
    LoggerConfiguration config = new LoggerConfiguration();
    config.setLogLevel(LoggingLevel.DEBUG);

    LoggingLevel level = config.getLogLevel();

    Assertions.assertEquals(LoggingLevel.DEBUG, level);
  }
}