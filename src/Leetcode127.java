import java.util.*;

public class Leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }

        HashMap<String, List<String>> wordGraph = new HashMap<>();

        for(int i = 0; i < beginWord.length(); i++) {
            String wildcard = beginWord.substring(0, i) + '*' + beginWord.substring(i + 1);
            if(wordGraph.containsKey(wildcard)) {
                wordGraph.get(wildcard).add(beginWord);
            } else {
                int finalI = i;
                wordGraph.put(wildcard, new LinkedList<>() {{
                    add(beginWord);
                }});
            }
        }

        for(int i = 0; i < wordList.size(); i++) {
            for(int j = 0; j < wordList.get(i).length(); j++) {
                String wildcard = wordList.get(i).substring(0, j) + '*' + wordList.get(i).substring(j + 1);
                if(wordGraph.containsKey(wildcard)) {
                    wordGraph.get(wildcard).add(wordList.get(i));
                } else {
                    int finalI = i;
                    wordGraph.put(wildcard, new LinkedList<>() {{
                        add(wordList.get(finalI));
                    }});
                }
            }
        }

        HashSet<String> visited = new HashSet<>();
        Queue<HashMap<String, Integer>> queue = new LinkedList<>();

        queue.offer(new HashMap<>() {{
            put(beginWord, 1);
        }});

        visited.add(beginWord);

        while(!queue.isEmpty()) {
            HashMap<String, Integer> current = queue.poll();
            String currentWord = current.keySet().iterator().next();
            int currentLevel = current.get(currentWord);

            for(int i = 0; i < currentWord.length(); i++) {
                String wildcard = currentWord.substring(0, i) + '*' + currentWord.substring(i + 1);
                if(wordGraph.containsKey(wildcard)) {
                    for(String neighbor : wordGraph.get(wildcard)) {
                        if(neighbor.equals(endWord)) {
                            return currentLevel + 1;
                        }
                        if(!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(new HashMap<>() {{
                                put(neighbor, currentLevel + 1);
                            }});
                        }
                    }
                    wordGraph.get(wildcard).clear();
                }
            }
        }
        return 0;
    }


}




