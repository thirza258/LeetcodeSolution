import java.util.HashMap;

public class Leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(map.containsKey(c)) {
                if(map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode383 leetcode383 = new Leetcode383();
        System.out.println(leetcode383.canConstruct("aa", "aab"));
    }
}
