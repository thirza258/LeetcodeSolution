import java.util.ArrayList;
import java.util.List;

public class Leetcode151 {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder sSb = new StringBuilder();
        for(int i = words.length - 1; i > 0; i--) {
            sSb.append(words[i]);
            sSb.append(" ");
        }
        sSb.append(words[0]);
        return sSb.toString();
    }

    public static void main(String[] args) {
        Leetcode151 leetcode151 = new Leetcode151();
        System.out.println(leetcode151.reverseWords("a good   example"));
    }
}
