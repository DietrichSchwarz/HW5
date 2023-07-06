package edu.hillel;

import java.util.HashMap;

public class ArrayValueCalculator {

    public static void main(String[] args) {
        Array array1 = new Array(getFilledArray(4, 4));
        Array array2 = new Array(getFilledArray(4, 3));
        Array array3 = new Array(getFilledArray(4, 4));
        array3.set(3, 3, "abc");

        HashMap<String, Array> arrayMap = new HashMap<>();
        arrayMap.put("array1", array1);
        arrayMap.put("array2", array2);
        arrayMap.put("array3", array3);

        printResult(arrayMap);
    }

    //create an array with the given size and fill it with numbers from 1
    public static String[][] getFilledArray(int numRows, int numCols) {
        String[][] array = new String[numRows][numCols];
        int counter = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = String.valueOf(counter++);
            }
        }
        return array;
    }

    //calculate the sum of the elements
    private static int doCalc(Array array) throws ArrayException {
        int sum = 0;
        int numRows = 4;
        int numCols = 4;

        if (array.numRows() != numRows || array.numCols() != numCols) {
            throw new ArrayException.ArraySizeException("Array size should be 4x4");
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                try {
                    sum += Integer.parseInt(array.get(i, j));
                } catch (NumberFormatException exception) {
                    throw new ArrayException.ArrayDataException("Invalid data in cell [" + i + "][" + j + "]: " + array.get(i, j), exception);
                }
            }
        }
        return sum;
    }

    //output the result to the console
    private static void printResult(HashMap<String, Array> arrayMap) {
        try {
            if (arrayMap.isEmpty()) {
                throw new IllegalArgumentException("The arrayMap is empty");
            }

            arrayMap.forEach((key, value) -> {
                try {
                    int sum = doCalc(value);
                    System.out.println(key + " result = " + sum);
                } catch (ArrayException exception) {
                    System.err.println(key + " result = " + exception.getMessage());
                }
            });
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }
    }
}