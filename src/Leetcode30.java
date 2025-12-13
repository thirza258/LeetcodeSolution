import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode30 {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || s.length() == 0 || words == null || words.length == 0) {
            return List.of();
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLength * wordCount;
        HashMap<String, Integer> wordMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for(int i = 0; i < wordLength; i++) {
            int leftBoundary = i;
            HashMap<String, Integer> windowMap = new HashMap<>();
            int matchedWords = 0;
            for(int j = i; j + wordLength <= s.length(); j += wordLength) {
                String sub = s.substring(j, j+wordLength);
                if(!wordMap.containsKey(sub)) {
                    windowMap.clear();
                    matchedWords = 0;
                    leftBoundary = j + wordLength;
                } else {
                    windowMap.put(sub, windowMap.getOrDefault(sub, 0) + 1);
                    if (windowMap.get(sub) <= wordMap.get(sub)) {
                        matchedWords++;
                    }

                    while(windowMap.get(sub) > wordMap.get(sub)) {
                        String leftWord = s.substring(leftBoundary, leftBoundary + wordLength);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        if (windowMap.get(leftWord) < wordMap.get(leftWord)) {
                            matchedWords--;
                        }
                        leftBoundary += wordLength;
                    }

                    if(matchedWords == wordCount) {
                        result.add(leftBoundary);
                        String leftWord = s.substring(leftBoundary, leftBoundary + wordLength);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        if (windowMap.get(leftWord) < wordMap.get(leftWord)) {
                            matchedWords--;
                        }
                        leftBoundary += wordLength;
                    }
                }

            }
        }
        return result;

    }
}
