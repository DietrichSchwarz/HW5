package consoleLogger;

import edu.hillel.consoleLogger.StdoutLoggerConfiguration;
import edu.hillel.logger.LoggingLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StdoutLoggerConfigurationTest {
  @Test
  void testStdoutLoggerConfigurationConstructor() {
    LoggingLevel expectedLogLevel = LoggingLevel.DEBUG;
    StdoutLoggerConfiguration config = new StdoutLoggerConfiguration(expectedLogLevel);
    Assertions.assertEquals(expectedLogLevel, config.getLogLevel());
  }
}