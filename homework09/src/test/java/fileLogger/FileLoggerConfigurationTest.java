package fileLogger;

import edu.hillel.fileLogger.FileLoggerConfiguration;
import edu.hillel.logger.LoggingLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileLoggerConfigurationTest {
  @Test
  void testFileLoggerConfigurationConstructor() {
    String expectedPath = "path";
    LoggingLevel expectedLogLevel = LoggingLevel.INFO;
    long expectedMaxFileSize = 1024;
    String expectedFileFormat = "txt";

    FileLoggerConfiguration configuration =
        new FileLoggerConfiguration(expectedPath, expectedLogLevel, expectedMaxFileSize,
            expectedFileFormat);

    Assertions.assertEquals(expectedPath, configuration.getPath());
    Assertions.assertEquals(expectedLogLevel, configuration.getLogLevel());
    Assertions.assertEquals(expectedMaxFileSize, configuration.getMaxFileSize());
    Assertions.assertEquals(expectedFileFormat, configuration.getFileFormat());
  }
}
