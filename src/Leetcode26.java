

public class Leetcode26 {
    //from me
    public static int removeDuplicates(int[] nums) {
        int jumlahArray = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                continue;
            } else {
                ++jumlahArray;
                nums[jumlahArray] = nums[i];
            }
        }
        return jumlahArray + 1;
    }

    //from udemy
    public int removeDuplicats(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
 
        int i = 0;
 
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
 
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 4, 4, 5, 6, 7,7, 8, 9}));
    }
}
