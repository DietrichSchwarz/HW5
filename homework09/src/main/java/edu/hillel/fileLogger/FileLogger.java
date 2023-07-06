package edu.hillel.fileLogger;

import edu.hillel.logger.AbstractLogger;
import edu.hillel.logger.LoggingLevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileLogger extends AbstractLogger {

  private final FileLoggerConfiguration configuration;
  private File currentLogFile;


  public FileLogger(FileLoggerConfiguration configuration) {
    this.configuration = configuration;
    this.currentLogFile = createNewLogFile();
  }

  //create a new file
  private File createNewLogFile() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
    String newName = String.format("%s_%s.%s", "log", LocalDateTime.now().format(formatter),
        configuration.getFileFormat());

    String fullLogFilePath = configuration.getPath() + newName;
    File logFile = new File(fullLogFilePath);
    try {
      Thread.sleep(
          1000);//necessary measure because the lock of the process itself on the file does not have time to be removed
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return logFile;
  }

  @Override
  public void debug(String message) {
    log(LoggingLevel.DEBUG, message);
  }

  @Override
  public void info(String message) {
    log(LoggingLevel.INFO, message);
  }


  //write a log depending on level
  @Override
  public void log(LoggingLevel level, String message) {
    String formattedMessage = getFormattedMessage(level, message);
    long messageSize = formattedMessage.getBytes().length;

    try {
      checkFileMaxSize(messageSize);
    } catch (FileMaxSizeReachedException e) {
      currentLogFile = createNewLogFile();
    }

    if (level.ordinal() <= configuration.getLogLevel().ordinal()) {
      writeToFile(currentLogFile, formattedMessage);
    }
  }


  //check file size and size from config
  private void checkFileMaxSize(long messageSize) throws FileMaxSizeReachedException {
    long fileSize = currentLogFile.length();
    long maxFileSize = configuration.getMaxFileSize();

    if (fileSize + messageSize >= maxFileSize) {
      throw new FileMaxSizeReachedException(fileSize + messageSize, maxFileSize,
          currentLogFile.getPath());
    }
  }

  //write a message to the file
  private void writeToFile(File currentLogFile, String message) {
    FileWriter fileWriter = null;
    BufferedWriter writer = null;
    try {
      fileWriter = new FileWriter(currentLogFile, true);
      writer = new BufferedWriter(fileWriter);
      writer.write(message);
      writer.newLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        if (writer != null) {
          writer.close();
        }
        if (fileWriter != null) {
          fileWriter.close();
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}