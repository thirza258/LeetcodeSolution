

import java.util.HashMap;

/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
 * 
 */

public class Leetcode1 {

    /*
     * 1. Twosum with bruteforce
     */
    public int[] twoSum(int[] nums, int target) {
        // iterasi pertama untuk mencari angka pertama
        for(int i = 0; i < nums.length; i++) {
            // iterasi kedua untuk mencari angka kedua
            for(int j = i + 1; j < nums.length; j++) {
                // jika angka pertama dan kedua sama dengan target
                if(nums[i] + nums[j] == target)
                    //mengembalikan indeks dari angka pertama dan kedua
                    return new int[]{i, j};
            }
        }
        return nums;
    }

    /*
     * 1. Twosum with hashmap
     */
    public int[] twoSums(int[] nums, int target) {
        // inisiasi hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        // mengiterasi array nums untuk mencari angka yang cocok
        for(int i = 0; i < nums.length; i++) {
            // mencari angka yang cocok dengan target dengan mengurangi target dengan angka yang sedang diiterasi
            int complement = target - nums[i];

            // jika hashmap mengandung angka yang cocok dengan target
            if(map.containsKey(complement)) {
                // mengembalikan indeks dari angka yang cocok dengan target dan angka yang sedang diiterasi
                return new int[]{map.get(complement), i};
            }
            // memasukkan angka yang sedang diiterasi dan indeksnya ke hashmap
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        Leetcode1 leetcode1 = new Leetcode1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(leetcode1.twoSum(nums, target)[0]);
    }
}
