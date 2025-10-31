import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {
    public List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0 || k > n) {
            return List.of();
        }
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> currentCombination = new ArrayList<>();
        for(int i = 1; i <= k; i++) {
            currentCombination.add(i);
        }

        while(true) {
            result.add(new ArrayList<>(currentCombination));

            int index = -1;
            for(int i = k - 1; i >= 0; i--) {
                int maxValue = n - (k-1-i);
                if(currentCombination.get(i) < maxValue) {
                    index = i;
                    break;
                }
            }
            if(index == -1) {
                break;
            }
            int newValue = currentCombination.get(index) + 1;
            currentCombination.set(index, newValue);
            for(int i = index + 1; i < k; i++) {
                newValue++;
                currentCombination.set(i, newValue);
            }
        }
        return result;
    }
}
