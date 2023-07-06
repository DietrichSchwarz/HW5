package consoleLogger;

import edu.hillel.consoleLogger.StdoutLoggerConfiguration;
import edu.hillel.consoleLogger.StdoutLoggerConfigurationLoader;
import org.junit.jupiter.api.Test;
import edu.hillel.logger.LoggingLevel;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;

public class StdoutLoggerConfigurationLoaderTest {
  private static final String pathToConfig = "src/test/resources/logConfig.txt";

  @Test
  void testLoadConfigurationFromValidFile() throws IOException {
    StdoutLoggerConfiguration configuration = StdoutLoggerConfigurationLoader.load(pathToConfig);
    Assertions.assertTrue(configuration.getLogLevel() == LoggingLevel.INFO ||
        configuration.getLogLevel() == LoggingLevel.DEBUG);
  }

  @Test
  void testLoadConfigurationFromInvalidFile() {
    Assertions.assertThrows(IOException.class, () -> StdoutLoggerConfigurationLoader.load("pathToConfig"));
  }
}