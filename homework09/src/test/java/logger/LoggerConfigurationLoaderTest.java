package logger;

import java.io.IOException;
import edu.hillel.logger.LoggerConfiguration;
import edu.hillel.logger.LoggerConfigurationLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoggerConfigurationLoaderTest {

  @Test
  void testLoadWithValidConfigPath() throws IOException {
    LoggerConfiguration config = LoggerConfigurationLoader.load("valid/config/path");
    Assertions.assertNull(config);
  }
}