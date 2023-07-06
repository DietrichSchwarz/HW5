package edu.hillel;

public interface StringArray2D {
    String get(int row, int col);
    void set(int row, int col, String value);
    int numRows();
    int numCols();
}
