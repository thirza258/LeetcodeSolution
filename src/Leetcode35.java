public class Leetcode35 {
    public int searchInsert(int[] nums, int target) {
        // jika nums kosong, return 0
        if(nums.length==0) {
            return 0;
        }
        
        // inisiasi nilai firstIndex, lastIndex, dan midIndex
        int firstIndex = 0;
        int lastIndex = nums.length;
        int midIndex = 0;

        // jika target lebih besar dari nilai terakhir di nums, return panjang nums
        if(target > nums[lastIndex - 1]) {
            return lastIndex;
        }

        // selama firstIndex lebih kecil atau sama dengan lastIndex
        while(firstIndex <= lastIndex) {
            // midIndex adalah nilai tengah dari firstIndex dan lastIndex
            midIndex = (firstIndex + lastIndex) / 2;
            // jika nilai midIndex sama dengan target, return midIndex
            if(nums[midIndex] == target) {
                return midIndex;
            }

            // Jika nilai target lebih kecil dari nilai di nums[midIndex], lastIndex adalah midIndex - 1
            if(target < nums[midIndex]) {
                lastIndex = midIndex - 1;
            } else {
                // Jika nilai target lebih besar dari nilai di nums[midIndex], firstIndex adalah midIndex + 1
                firstIndex = midIndex + 1;
            }
        }
        return firstIndex;
    }

    public static void main(String[] args) {
        Leetcode35 leetcode35 = new Leetcode35();
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(leetcode35.searchInsert(nums, target));
    }
    
}
