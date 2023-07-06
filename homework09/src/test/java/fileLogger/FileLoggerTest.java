package fileLogger;

import edu.hillel.fileLogger.FileLogger;
import edu.hillel.fileLogger.FileLoggerConfiguration;
import edu.hillel.logger.LoggingLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileLoggerTest {
  @Test
  void testFileLoggerConstructor() {
    FileLoggerConfiguration configuration =
        new FileLoggerConfiguration("homework9/src/test/resources/logConfig.txt",
            LoggingLevel.INFO, 1024,
            "txt");
    FileLogger logger = new FileLogger(configuration);

    Assertions.assertEquals(configuration, logger.getConfiguration());
    Assertions.assertNotNull(logger.getCurrentLogFile());
  }

  @Test
  void testDebug() {
    FileLoggerConfiguration configuration =
        new FileLoggerConfiguration("homework9/src/test/resources/logConfig.txt",
            LoggingLevel.INFO, 1024,
            "txt");
    FileLogger logger = new FileLogger(configuration);

    logger.debug("test info");
  }

  @Test
  void testInfo() {

  }
}