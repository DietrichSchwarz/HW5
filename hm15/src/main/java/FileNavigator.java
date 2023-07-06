package edu.hillel;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import lombok.Data;

/**
 * The class is designed to store a list of files that are located on a specific path.
 */
@Data
public class FileNavigator {
  private final Map<String, Set<FileData>> fileMap;

  public FileNavigator() {
    this.fileMap = new HashMap<>();
  }

  /**
   * The method adds a file to the specified path.
   */
  public void add(String path, FileData file) {
    if (!file.getPath().equals(path)) {
      throw new IllegalArgumentException(
          "Cannot add file with path " + file.getPath() + " to directory " + path);
    }
    fileMap.computeIfAbsent(path, k -> new HashSet<>()).add(file);
  }

  /**
   * The method returns a list of files associated with the path passed as a parameter.
   */
  public Set<FileData> find(String path) {
    return fileMap.getOrDefault(path, new HashSet<>());
  }

  /**
   * The method returns a list of files whose size (in bytes)
   * does not exceed the value passed as a parameter.
   */
  public Set<FileData> filterBySize(String path, long size) {
    if (!fileMap.containsKey(path)) {
      return new HashSet<>();
    }
    Set<FileData> filteredSet = new HashSet<>();
    for (FileData file : fileMap.get(path)) {
      if (file.getSize() <= size) {
        filteredSet.add(file);
      }
    }
    return filteredSet;
  }

  /**
   * The method removes the path and its associated files
   * based on the path value passed as a parameter.
   */
  public void remove(String path) {
    fileMap.remove(path);
  }

  /**
   * The method sorts all available files by size (ascending),
   * then returns a list of the sorted files.
   */
  public Set<FileData> sortBySize(String path) {
    if (!fileMap.containsKey(path)) {
      return new HashSet<>();
    }

    Set<FileData> filteredSet = new TreeSet<>(Comparator.comparingLong(FileData::getSize));
    filteredSet.addAll(fileMap.get(path));

    return filteredSet;
  }
}