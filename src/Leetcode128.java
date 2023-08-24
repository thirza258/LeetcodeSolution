import java.util.HashMap;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int max_sequence = 0;
        for(int i = 0; i < nums.length; i++) {
            int current = 1;

            for(int j = nums[i] + 1; map.containsKey(j) ;j++) {
                current++;
                map.remove(j);
            }

            for(int j = nums[i] - 1; map.containsKey(j); j--) {
                current++;
                map.remove(j);
            }

            if(max_sequence < current) {
                max_sequence = current;
            }
            if(map.size() == 0) {
                break;
            }
        }

        return max_sequence;
    }

    public static void main(String[] args) {
        Leetcode128 l = new Leetcode128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(l.longestConsecutive(nums));
    }
}
