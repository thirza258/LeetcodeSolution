public class Leetcode334 {
    public boolean increasingTriplet(int[] nums) {
        // Inisialisasi nilai result dengan false
        boolean result = false;
        // jika panjang dari array nums kurang dari 3, maka return result
        if(nums.length < 3) {
            return result;
        }

        // inisiasi nilai first dengan nilai nums[0]
        int first = nums[0];
        // inisiasi nilai second dengan nilai maksimum dari integer
        int second = Integer.MAX_VALUE;

        // iterasi nilai array nums dan tergantung juga nilai result
        for(int i = 1; i < nums.length && !result; i++) {
            // Jika nilai sekarang lebih besar dari nilai second
            if(nums[i] > second) {
                // maka set nilai result dengan true
                result = true;
            }
            // Jika nilai sekarang lebih besar dari nilai first dan nilai sekarang kurang dari nilai second
            else if(nums[i] > first && nums[i] < second) {
                // maka set nilai second dengan nilai sekarang
                second = nums[i];
            }
            // Jika nilai sekarang kurang dari nilai first
            else if(nums[i] < first) {
                // maka set nilai first dengan nilai sekarang
                first = nums[i];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Leetcode334 leetcode334 = new Leetcode334();
        int[] nums = {1,2,3,4,5};
        System.out.println(leetcode334.increasingTriplet(nums));
    }
}
