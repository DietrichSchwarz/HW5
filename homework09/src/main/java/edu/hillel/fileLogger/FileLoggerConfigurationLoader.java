package edu.hillel.fileLogger;


import edu.hillel.logger.LoggerConfigurationLoader;
import edu.hillel.logger.LoggingLevel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader extends LoggerConfigurationLoader {


  public static FileLoggerConfiguration load(String configPath) throws IOException {
    String path = null;
    LoggingLevel logLevel = null;
    long maxFileSize = 0;
    final long DEFAULT_MAX_FILE_SIZE = 1000;
    String fileFormat = null;

    try (BufferedReader reader = new BufferedReader(new FileReader(configPath))) {
      String line;

      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(": ");
        if (parts.length != 2) {
          continue;
        }

        String key = parts[0].trim().toUpperCase();
        String value = parts[1].trim();

        switch (key) {
          case "FILE":
            path = value;
            break;
          case "LEVEL":
            logLevel = LoggingLevel.valueOf(value.toUpperCase());
            break;
          case "MAX-SIZE":
            try {
              maxFileSize = Long.parseLong(value);
            } catch (NumberFormatException e) {
              e.printStackTrace();
              maxFileSize = DEFAULT_MAX_FILE_SIZE;
            }
            break;
          case "FORMAT":
            fileFormat = value.toLowerCase();
            break;
          default:
            System.err.println("unknown key");
            break;
        }
      }
    }
    return new FileLoggerConfiguration(path, logLevel, maxFileSize, fileFormat);
  }
}