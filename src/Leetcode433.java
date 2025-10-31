import java.util.*;

public class Leetcode433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        if(endGene == null || endGene.length() == 0) {
            return -1;
        }

        bankSet.addAll(Arrays.asList(bank));

        if(!bankSet.contains(endGene)) {
            return -1;
        }

        Deque<Map<String, Integer>> queue = new ArrayDeque<>();
        queue.add(new HashMap<String, Integer>() {{
            put(startGene, 0);
        }});
        HashSet<String> visited = new HashSet<>();
        visited.add(startGene);

        List<String> geneOptions = Arrays.asList("A", "C", "G", "T");

        while(!queue.isEmpty()) {
            Map<String, Integer> current = queue.poll();

            if(current.containsKey(endGene)) {
                return current.get(endGene);
            }

            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < geneOptions.size(); j++) {
                    String mutatedGene = current.keySet().iterator().next().substring(0, i) + geneOptions.get(j) + current.keySet().iterator().next().substring(i + 1);
                    if(bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                        visited.add(mutatedGene);
                        int currentMutations = current.get(current.keySet().iterator().next());
                        queue.add(new HashMap<String, Integer>() {{
                            put(mutatedGene, currentMutations + 1);
                        }});
                    }
                }
            }
        }
        return -1;
    }
}
