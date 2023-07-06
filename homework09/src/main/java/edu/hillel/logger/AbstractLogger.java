package edu.hillel.logger;


import static edu.hillel.logger.LoggingLevel.DEBUG;
import static edu.hillel.logger.LoggingLevel.INFO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class AbstractLogger {

  public void info(String message) {
    log(INFO, message);
  }

  public void debug(String message) {
    log(DEBUG, message);
  }

  public abstract void log(LoggingLevel level, String message);

  //generate messages in the specified format
  public String getFormattedMessage(LoggingLevel level, String message) {
    String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    String logLevel = "[" + level.toString() + "]";
    return String.format("%s%s %s", timestamp, logLevel, message);
  }
}