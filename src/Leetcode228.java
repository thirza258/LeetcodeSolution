import java.util.List;
import java.util.ArrayList;

public class Leetcode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int len = nums.length;
        if(len == 0) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for(int i = 1; i < len; i++) {
            if(nums[i] == end + 1) {
                end = nums[i];
                continue;
            } 

            result.add(helper(start, end));
            start = nums[i];
            end = nums[i];
        }

        result.add(helper(start, end));
        return result;
    }

    private String helper(int start, int end) {
        StringBuilder sb = new StringBuilder();
        if(start != end) {
            sb.append(start).append("->").append(end);
        }
        else {
            sb.append(start);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode228 leetcode228 = new Leetcode228();
        System.out.println(leetcode228.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
