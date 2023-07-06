package edu.hillel.consoleLogger;


import edu.hillel.logger.AbstractLogger;
import edu.hillel.logger.LoggingLevel;
import lombok.Data;

@Data
public class StdoutLogger extends AbstractLogger {
  private StdoutLoggerConfiguration configuration;

  public StdoutLogger(StdoutLoggerConfiguration configuration) {
    this.configuration = configuration;
  }

  @Override
  public void log(LoggingLevel level, String message) {
    if (level.ordinal() <= configuration.getLogLevel().ordinal()) {
      System.out.println(getFormattedMessage(level, message));
    }
  }
}