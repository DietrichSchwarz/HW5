package edu.hillel;

import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----2-----");
        String task2Word = "Occurrence";
        char task2Char = 'c';
        System.out.println("Number of found characters '" + task2Char + "' in the word " + task2Word + " = " + findSymbolOccurrence(task2Word, task2Char));

        System.out.println("-----3-----");
        String[] task3 = {"Apollo", "pollo", "Apple", "Plant"};
        System.out.println("Source = " + task3[0] + ". Target = " + task3[1] + ". Result = " + findWordPosition(task3[0], task3[1]));
        System.out.println("Source = " + task3[2] + ". Target = " + task3[3] + ". Result = " + findWordPosition(task3[2], task3[3]));

        System.out.println("-----4-----");
        String task4Word = "Hello";
        System.out.println(task4Word + " string reverse = " + stringReverse("Hello"));

        System.out.println("-----5-----");
        String[] task5 = {"ERE", "Allo"};
        System.out.println(task5[0] + " is palindrome = " + isPalindrome(task5[0]));
        System.out.println(task5[1] + " is palindrome = " + isPalindrome(task5[1]));

        System.out.println("-----6-----");
        GuessTheWord();
    }

    //2
    private static int findSymbolOccurrence(String str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    //3
    private static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    //4
    private static String stringReverse(String str) {
        StringBuilder reversedStr = new StringBuilder(str).reverse();
        return reversedStr.toString();
    }

    //5
    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //6
    private static void GuessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        String secretWord = words[random.nextInt(words.length)];
        StringBuilder hiddenWord = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            hiddenWord.append("#");
        }
        String guess;

        do {
            System.out.println("Guess the word: " + hiddenWord);
            guess = scanner.nextLine().toLowerCase();
            if (guess.equals(secretWord)) {
                System.out.println("Congratulations! You guessed the word!");
                return;
            } else {
                StringBuilder partiallyHiddenWord = new StringBuilder(hiddenWord);
                for (int i = 0; i < Math.min(guess.length(), secretWord.length()); i++) {
                    if (guess.charAt(i) == secretWord.charAt(i)) {
                        partiallyHiddenWord.setCharAt(i, guess.charAt(i));
                    }
                }
                hiddenWord = new StringBuilder(partiallyHiddenWord.toString());
            }
        } while (true);
    }
}