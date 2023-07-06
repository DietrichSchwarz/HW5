package edu.hillel;

import edu.hillel.consoleLogger.StdoutLoggerConfigurationLoader;
import edu.hillel.fileLogger.FileLoggerConfigurationLoader;
import edu.hillel.logger.AbstractLogger;
import edu.hillel.logger.LoggerConfiguration;
import edu.hillel.logger.LoggerFactory;
import edu.hillel.logger.LoggerType;
import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    String pathToConfig = "homework9/src/main/resources/logConfig.txt";

    LoggerConfiguration config = FileLoggerConfigurationLoader.load(pathToConfig);
    AbstractLogger fileLogger = LoggerFactory.getLogger(LoggerType.FILE, config);

    config = StdoutLoggerConfigurationLoader.load(pathToConfig);
    AbstractLogger stdoutLogger = LoggerFactory.getLogger(LoggerType.STDOUT, config);

    for (int i = 0; i < 20; i++) {
      fileLogger.info("test info" + " " + i);
      fileLogger.debug("test debug" + " " + i);
    }

    for (int i = 0; i < 20; i++) {
      stdoutLogger.info("test info" + " " + i);
      stdoutLogger.debug("test debug" + " " + i);
    }
  }
}