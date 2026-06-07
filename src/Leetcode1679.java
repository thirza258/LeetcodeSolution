import java.util.Arrays;
import java.util.HashMap;

public class Leetcode1679 {
    public int maxOperations(int[] nums, int k) {
//        if (nums == null || nums.length == 0) return 0;
//
//        Arrays.sort(nums);
//
//        int left = 0;
//        int right = nums.length - 1;
//        int result = 0;
//
//        while(left < right) {
//            int sum = nums[left] + nums[right];
//            if(sum == k) {
//                result += 1;
//                left++;
//                right--;
//            }
//            else if(sum < k) {
//                left++;
//            }
//            else {
//                right--;
//            }
//        }
//
//        return result;

        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int i=0;i<nums.length;i++){
            int current = nums[i];
            int target = k - current;
            int cnt = map.getOrDefault(target,0);
            if(cnt > 0) {
                result++;
                if(cnt == 1) {
                    map.remove(target);
                }else {
                    map.put(target, cnt - 1);
                }
            } else{
                map.put(current, map.getOrDefault(current,0)+1);
            }

        }
        return result;
        
    }
}
