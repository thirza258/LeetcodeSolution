package Hackerank;

import java.util.regex.Pattern;

public class TypeCounter {
    public static void typeCounter(String sentence) {
        // Initialize counters
        int stringCount = 0;
        int integerCount = 0;
        int doubleCount = 0;

        // Split sentence into words
        String[] words = sentence.trim().split("\\s+");

        // Regex patterns for type checking
        Pattern stringPattern = Pattern.compile("^[a-z]+$"); // Match only lowercase strings
        Pattern integerPattern = Pattern.compile("^\\d+$"); // Match integers (only digits)
        Pattern doublePattern = Pattern.compile("^\\d*\\.\\d+$"); // Match doubles (e.g., 12.34)

        // Process each word
        for (String word : words) {
            if (stringPattern.matcher(word).matches()) {
                stringCount++;  // Count lowercase alphabetic words
            } else if (doublePattern.matcher(word).matches()) {
                doubleCount++;  // Count valid doubles
            } else if (integerPattern.matcher(word).matches()) {
                integerCount++;  // Count valid integers
            }
        }

        // Print results in required format
        System.out.println("string " + stringCount);
        System.out.println("integer " + integerCount);
        System.out.println("double " + doubleCount);
    }
    public static void main(String[] args) {
        String sentence = "hello 123 45.67 world !@#$% Abcdef";
        typeCounter(sentence);
    }
}
