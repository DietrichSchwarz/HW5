package fileLogger;

import edu.hillel.fileLogger.FileLoggerConfiguration;
import edu.hillel.fileLogger.FileLoggerConfigurationLoader;
import edu.hillel.logger.LoggingLevel;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileLoggerConfigurationLoaderTest {

  private static final String pathToConfig = "src/test/resources/logConfig.txt";

  @Test
  void testLoadConfigurationFromValidFile() throws IOException {
    FileLoggerConfiguration configuration = FileLoggerConfigurationLoader.load(pathToConfig);
    Assertions.assertTrue(configuration.getLogLevel() == LoggingLevel.INFO ||
        configuration.getLogLevel() == LoggingLevel.DEBUG);
  }

  @Test
  void testLoadConfigurationFromInvalidFile() {
    Assertions.assertThrows(IOException.class,
        () -> FileLoggerConfigurationLoader.load("pathToConfig"));
  }
}
