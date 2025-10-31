import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode17 {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, List<Character>> digitToLetters = new HashMap<>();
        digitToLetters.put('2', Arrays.asList('a', 'b', 'c'));
        digitToLetters.put('3', Arrays.asList('d', 'e', 'f'));
        digitToLetters.put('4', Arrays.asList('g', 'h', 'i'));
        digitToLetters.put('5', Arrays.asList('j', 'k', 'l'));
        digitToLetters.put('6', Arrays.asList('m', 'n', 'o'));
        digitToLetters.put('7', Arrays.asList('p', 'q', 'r', 's'));
        digitToLetters.put('8', Arrays.asList('t', 'u', 'v'));
        digitToLetters.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0) {
            return result;
        }

        for(int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            List<Character> letters = digitToLetters.get(digits.charAt(i));
            if(result.size() == 0) {
                for(int j = 0; j < letters.size(); j++) {
                    temp.add(String.valueOf(letters.get(j)));
                }
            } else {
                for(int j = 0; j < result.size(); j++) {
                    for(int k = 0; k < letters.size(); k++) {
                        temp.add(result.get(j) + letters.get(k));
                    }
                }
            }
            result = temp;
        }
        return result;
    }
}
