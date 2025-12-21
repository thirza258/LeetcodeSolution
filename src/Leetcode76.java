import java.util.HashMap;
import java.util.Objects;

public class Leetcode76 {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> mapT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = mapT.size();
        int target = 0;

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        StringBuilder result = new StringBuilder();

        while(right < s.length()) {
            char c = s.charAt(right);
            if(mapT.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(Objects.equals(window.get(c), mapT.get(c))) {
                    target++;
                }
            }

            if(target == required) {
                while(target == required) {
                    int currentLength = right - left + 1;
                    if(currentLength < minLength) {
                        minLength = currentLength;
                        startIndex = left;
                    }
                    Character leftChar = s.charAt(left);
                    if(mapT.containsKey(leftChar)) {
                        window.put(leftChar, window.get(leftChar) - 1);
                        if(window.get(leftChar) < mapT.get(leftChar)) {
                            target--;
                        }
                    }
                    left++;
                }
            }
            right++;
        }

        if(minLength == Integer.MAX_VALUE) {
            return "";
        }

        for(int i = startIndex; i < startIndex + minLength; i++) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}
