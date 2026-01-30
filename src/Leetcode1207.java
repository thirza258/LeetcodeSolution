import java.util.HashMap;

public class Leetcode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr.length == 0) {
            return true;
        }

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        HashMap<Integer, Boolean> occurrenceMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        for(Integer key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if(occurrenceMap.containsKey(frequency)) {
                return false;
            } else {
                occurrenceMap.put(frequency, true);
            }
        }

        return true;
    }
}
