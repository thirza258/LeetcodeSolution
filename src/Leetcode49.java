import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;

public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new java.util.ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String sorted = new String(wordArray);
            if(!map.containsKey(sorted)) {
                List<String> list = new ArrayList<>();
                list.add(word);
                result.add(list);
                map.put(sorted, result.size() - 1);
            }
            else {
                result.get(map.get(sorted)).add(word);
            }
        }

        for(int i = 0; i < result.size(); i++) {
            Collections.sort(result.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode49 l = new Leetcode49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = l.groupAnagrams(strs);
        System.out.println(result);
    }
}
