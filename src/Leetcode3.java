import java.util.HashMap;

public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int maxLen = 0;
        int lastRepeatPosition = -1;

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)) && lastRepeatPosition < map.get(s.charAt(i))) {
                lastRepeatPosition = map.get(s.charAt(i));
            }
            if((i - lastRepeatPosition) > maxLen) {
                maxLen = i - lastRepeatPosition;
            }
            map.put(s.charAt(i), i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Leetcode3 lc = new Leetcode3();
        System.out.println(lc.lengthOfLongestSubstring("abcabcbb"));
    }
}
