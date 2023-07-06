package edu.hillel.fileLogger;

public class FileMaxSizeReachedException extends Exception {

  long currentSize;
  long maxSize;
  String path;

  public FileMaxSizeReachedException(long currentSize, long maxSize, String path) {
    super(String.format(
        "File max size reached. Current size: %d bytes. Max size: %d bytes. Path %s",
        currentSize, maxSize, path));
    this.currentSize = currentSize;
    this.maxSize = maxSize;
    this.path = path;
  }
}