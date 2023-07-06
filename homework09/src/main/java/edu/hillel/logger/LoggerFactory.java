package edu.hillel.logger;

import edu.hillel.consoleLogger.StdoutLogger;
import edu.hillel.consoleLogger.StdoutLoggerConfiguration;
import edu.hillel.fileLogger.FileLogger;
import edu.hillel.fileLogger.FileLoggerConfiguration;

public class LoggerFactory {
  public static AbstractLogger getLogger(LoggerType type, LoggerConfiguration configuration) {
    switch (type) {
      case FILE:
        return new FileLogger((FileLoggerConfiguration) configuration);
      case STDOUT:
        return new StdoutLogger((StdoutLoggerConfiguration) configuration);
      default:
        throw new IllegalArgumentException("Unknown edu.hillel.logger type: " + type);
    }
  }
}