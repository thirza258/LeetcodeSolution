
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array nums of distinct integers, return all the possible permutations. 
 * You can return the answer in any order.
 */

public class Leetcode46 {
    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();


        if(nums.length < 2) {
            for(int i = 0; i < nums.length; i++) {
                current.add(nums[i]);
            }
            result.add(current);
            return result;
        }


        for(int i = 0; i < nums.length - 1; i++) {
            current.add(nums[i]);
            for(int j = 0; j < current.size(); j++) {
                for(int k = i + 1; k < result.get(j).size(); k++) {
                    List<Integer> temp = current;
                }
            }
        }
    }
}
