import java.util.Arrays;

public class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        //dari kiri ke kanan
        for(int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        //dari kanan ke kiri
        int factorial = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            factorial = factorial * nums[i+1];
            result[i] = result[i] * factorial;
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode238 leetcode238 = new Leetcode238();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(leetcode238.productExceptSelf(nums)));
    }
}
