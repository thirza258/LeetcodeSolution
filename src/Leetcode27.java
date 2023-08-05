public class Leetcode27 {
    public int removeElement(int[] nums, int val) {
        // mulai dari index 0
        int index = 0;
        // untuk setiap elemen di nums
        for( int i=0; i < nums.length; i++) {
            // jika elemen tidak sama dengan val
            if(nums[i] !=val ) {
                // maka elemen di index akan menjadi elemen di nums
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Leetcode27 lc = new Leetcode27();
        int[] nums = {3,2,2,3};
        int val = 3;
        int result = lc.removeElement(nums, val);
        System.out.println(result);
    }
}
