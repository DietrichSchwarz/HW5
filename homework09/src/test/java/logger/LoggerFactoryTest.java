package logger;

import edu.hillel.consoleLogger.StdoutLogger;
import edu.hillel.consoleLogger.StdoutLoggerConfiguration;
import edu.hillel.fileLogger.FileLogger;
import edu.hillel.fileLogger.FileLoggerConfiguration;
import edu.hillel.logger.AbstractLogger;
import edu.hillel.logger.LoggerFactory;
import edu.hillel.logger.LoggerType;
import edu.hillel.logger.LoggingLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerFactoryTest {

  @Test
  public void testGetLoggerWithFileLoggerType() {
    String expectedPath = "path";
    LoggingLevel expectedLogLevel = LoggingLevel.INFO;
    long expectedMaxFileSize = 1024;
    String expectedFileFormat = "txt";

    FileLoggerConfiguration configuration =
        new FileLoggerConfiguration(expectedPath, expectedLogLevel, expectedMaxFileSize,
            expectedFileFormat);

    AbstractLogger logger = LoggerFactory.getLogger(LoggerType.FILE, configuration);
    Assertions.assertTrue(logger instanceof FileLogger);
    Assertions.assertEquals(configuration, ((FileLogger) logger).getConfiguration());
  }

  @Test
  public void testGetLoggerWithStdoutLoggerType() {
    LoggingLevel expectedLogLevel = LoggingLevel.INFO;

    StdoutLoggerConfiguration configuration =
        new StdoutLoggerConfiguration(expectedLogLevel);

    AbstractLogger logger = LoggerFactory.getLogger(LoggerType.STDOUT, configuration);
    Assertions.assertTrue(logger instanceof StdoutLogger);
    Assertions.assertEquals(configuration, ((StdoutLogger) logger).getConfiguration());
  }

  @Test
  public void testGetLoggerWithUnknownLoggerType() {
    Assertions.assertThrows(NullPointerException.class, () -> {
      LoggerFactory.getLogger(null, null);
    });
  }
}