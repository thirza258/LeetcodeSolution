import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();

        Stack<State> stack = new Stack<>();

        stack.push(new State(new ArrayList<>(), 0, 0));

        while (!stack.isEmpty()) {
            State currentState = stack.pop();

            if (currentState.sum == target) {
                result.add(currentState.combination);
                continue;
            }

            for (int i = currentState.startIndex; i < candidates.length; i++) {
                int newSum = currentState.sum + candidates[i];
                if (newSum <= target) {
                    List<Integer> newCombination = new ArrayList<>(currentState.combination);
                    newCombination.add(candidates[i]);
                    stack.push(new State(newCombination, newSum, i));
                }
            }
        }
        return result;
    }


}

class State {
    List<Integer> combination;
    int sum;
    int startIndex;

    public State(List<Integer> combination, int sum, int startIndex) {
        this.combination = combination;
        this.sum = sum;
        this.startIndex = startIndex;
    }
}