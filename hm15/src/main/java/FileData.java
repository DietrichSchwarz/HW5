package edu.hillel;

import lombok.Value;

/**
 * The class represents a specific file and consists of: file name, size in bytes, file path.
 */
@Value
public class FileData {
  String name;
  long size;
  String path;
}
