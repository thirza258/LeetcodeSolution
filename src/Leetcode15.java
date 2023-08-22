import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
     public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right) {
                int b = nums[left];
                int c = nums[right];

                if(a + b + c == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.add(c);

                    result.add(list);

                    while(left < (nums.length - 1) && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while(right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
                else if (a+b+c > 0) {
                    while(right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }
                else {
                    while(left < nums.length - 1 && nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode15 lc = new Leetcode15();
        int[] nums = {0,0,0};
        List<List<Integer>> result = lc.threeSum(nums);
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
