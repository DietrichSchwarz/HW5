package edu.hillel;

public class Array implements StringArray2D {
    private final String[][] data;

    public Array(String[][] data) {
        this.data = data;
    }

    @Override
    public String get(int row, int col) {
        return data[row][col];
    }

    @Override
    public void set(int row, int col, String value) {
        data[row][col] = value;
    }

    @Override
    public int numRows() {
        return data.length;
    }

    @Override
    public int numCols() {
        return data[0].length;
    }
}