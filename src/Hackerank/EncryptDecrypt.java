package Hackerank;

public class EncryptDecrypt {
    public static String decryptMessage(String encryptedMessage) {
        // Split the message into words
        String[] words = encryptedMessage.split(" ");

        // Reverse the word order
        StringBuilder decrypted = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            decrypted.append(decompressWord(words[i]));
            if (i > 0) {
                decrypted.append(" ");
            }
        }

        return decrypted.toString();
    }

    private static String decompressWord(String word) {
        StringBuilder decompressed = new StringBuilder();
        int i = 0;

        while (i < word.length()) {
            char currentChar = word.charAt(i);

            // Check if next character is a number (frequency)
            if (i + 1 < word.length() && Character.isDigit(word.charAt(i + 1))) {
                int frequency = word.charAt(i + 1) - '0';
                // Append the character 'frequency' times
                for (int j = 0; j < frequency; j++) {
                    decompressed.append(currentChar);
                }
                i += 2; // Skip the character and its frequency
            } else {
                decompressed.append(currentChar);
                i++;
            }
        }

        return decompressed.toString();
    }

    public static void main(String[] args) {
        String encryptedMessage = "mis2is2ip2i ba3 to hackerrank";
        String decryptedMessage = decryptMessage(encryptedMessage);
        System.out.println(decryptedMessage);
    }

    
}