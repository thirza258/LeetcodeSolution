
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array nums of distinct integers, return all the possible permutations. 
 * You can return the answer in any order.
 */

public class Leetcode46 {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> permutations = new ArrayList<>();
            for(int j = 0; j < result.size(); j++) {
                List<Integer> currentPermutation = result.get(j);
                for(int k = 0; k <= currentPermutation.size(); k++) {
                    List<Integer> newPermutation = new ArrayList<>(currentPermutation);
                    newPermutation.add(k, nums[i]);
                    permutations.add(newPermutation);
                }
            }

            result = permutations;
        }

        return result;
    }
}
