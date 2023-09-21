import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode139 {
    Map<String, Integer> map = new HashMap<>();

    public boolean help(int i, String s, Integer[] dp) {
        if (i == s.length()) return true;
        if (dp[i] != null) return dp[i] == 1;
        boolean ans = false;
        String a = "";
        for (int k = i; k < s.length(); k++) {
            a += s.charAt(k);
            if (map.containsKey(a)) {
                ans |= help(k + 1, s, dp);
            }
        }
        dp[i] = ans ? 1 : 0;
        return ans;
    }

    public boolean wordBreak(String s, List<String> w) {
        for (String str : w) {
            map.put(str, 1);
        }
        Integer[] dp = new Integer[s.length()];
        return help(0, s, dp);
    }

    

    public static void main(String[] args) {
        Leetcode139 lc = new Leetcode139();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(lc.wordBreak(s, wordDict));
    }
}
