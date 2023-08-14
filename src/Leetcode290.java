import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Leetcode290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternDict = new HashMap<>();
        Map<String, Character> sDict = new HashMap<>();

        int len = pattern.length();
        List<String> sList = split(s, ' ');

        if(len != sList.size()) {
            return false;
        }
        
        for(int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            String str = sList.get(i);

            if(!patternDict.containsKey(c)) {
                patternDict.put(c, str);
            }

            if(!sDict.containsKey(str)) {
                sDict.put(str, c);
            }
            if(!patternDict.get(c).equals(str) || !sDict.get(str).equals(c)) {
                return false;
            }
        }
        return true;

    }

    private List<String> split(String str, char del) {
        List<String> list = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, String.valueOf(del));
        while(tokenizer.hasMoreTokens()){
            list.add(tokenizer.nextToken());
        }
        return list;
    }

    public static void main(String[] args) {
        Leetcode290 leetcode290 = new Leetcode290();
        System.out.println(leetcode290.wordPattern("abba", "dog dog dog dog"));
    }
}
