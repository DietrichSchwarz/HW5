package edu.hillel.consoleLogger;

import edu.hillel.logger.LoggerConfigurationLoader;
import edu.hillel.logger.LoggingLevel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StdoutLoggerConfigurationLoader extends LoggerConfigurationLoader {

  public static StdoutLoggerConfiguration load(String configPath) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(configPath));
    String logLevel = null;
    String line;

    while ((line = reader.readLine()) != null) {
      String[] parts = line.split(": ");
      if (parts.length != 2) {
        continue;
      }

      String key = parts[0].trim().toUpperCase();
      String value = parts[1].trim();

      if (key.equals("LEVEL")) {
        logLevel = value.toUpperCase();
      }
    }
    reader.close();
    return new StdoutLoggerConfiguration(LoggingLevel.valueOf(logLevel));
  }
}