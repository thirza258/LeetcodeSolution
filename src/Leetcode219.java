import java.util.HashMap;
import java.util.Map;

public class Leetcode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(map.containsKey(n) && i - map.get(n) <= k) {
                return true;
            }
            map.put(n, i);
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode219 leetcode219 = new Leetcode219();
        System.out.println(leetcode219.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }
}
