package edu.hillel;

public class ArrayException extends Exception {

    public ArrayException(String errorMessage) {
        super(errorMessage);
    }

    static class ArraySizeException extends ArrayException {

        public ArraySizeException(String errorMessage) {
            super(errorMessage);
        }
    }

    static class ArrayDataException extends ArrayException {

        public ArrayDataException(String errorMessage, NumberFormatException exception) {
            super(errorMessage);
        }
    }
}