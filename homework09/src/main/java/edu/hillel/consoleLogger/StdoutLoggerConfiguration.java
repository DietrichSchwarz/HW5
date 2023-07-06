package edu.hillel.consoleLogger;

import edu.hillel.logger.LoggerConfiguration;
import edu.hillel.logger.LoggingLevel;

public class StdoutLoggerConfiguration extends LoggerConfiguration {
  private final LoggingLevel logLevel;

  public StdoutLoggerConfiguration(LoggingLevel logLevel) {
    this.logLevel = logLevel;
  }

  @Override
  public LoggingLevel getLogLevel() {
    return logLevel;
  }
}
