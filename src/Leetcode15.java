import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
     public List<List<Integer>> threeSum(int[] nums) {
        // inisiasi arraylist untuk menyimpan hasil
        List<List<Integer>> result = new ArrayList<>();
        
        // jika panjang array nums kurang dari 3
        if(nums.length < 3) {
            return result;
        }

        // melakukan sorting pada array nums
        Arrays.sort(nums);

        // iterasi untuk mencari angka pertama
        for(int i = 0; i < nums.length - 2; i++) {
            // jika angka pertama sama dengan angka sebelumnya maka lanjut ke angka berikutnya
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            // a untuk angka sekarang 
            int a = nums[i];
            // left untuk indeks di kiri
            int left = i + 1;
            // right untuk indeks di kanan
            int right = nums.length - 1;

            // selama indeks left kurang dari indeks right
            while(left < right) {
                // nilai b adalah nilai di indeks left
                int b = nums[left];
                // nilai c adalah nilai di indeks right
                int c = nums[right];

                // jika nilai a + b + c sama dengan 0
                if(a + b + c == 0) {
                    // membuat arraylist untuk menyimpan angka a, b, dan c
                    List<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.add(c);

                    // menambahkan list ke result
                    result.add(list);

                    // selama indeks left kurang dari indeks akhir dan 
                    // nilai di indeks left sama dengan nilai di indeks left + 1 atau indeks setelahnya
                    while(left < (nums.length - 1) && nums[left] == nums[left+1]) {
                        // maka indeks left ditambah 
                        left++;
                    }
                    // selama indeks right lebih dari 0 dan
                    // nilai di indeks right sama dengan nilai di indeks right - 1 atau indeks sebelumnya
                    while(right > 0 && nums[right] == nums[right - 1]) {
                        // maka indeks right dikurangi
                        right--;
                    }

                    // terus pindahkan indeks left dan right
                    left++;
                    right--;
                }
                // jika a + b + c lebih dari 0
                else if (a+b+c > 0) {
                    // selama indeks right lebih dari 0 dan
                    // nilai di indeks right sama dengan nilai di indeks right - 1 atau indeks sebelumnya
                    while(right > 0 && nums[right] == nums[right - 1]) {
                        // memindahkan indeks kekiri
                        right--;
                    }
                    // memindahkan lagi indeks kekiri
                    right--;
                }
                else {
                    // selama indeks left kurang dari indeks akhir dan
                    // nilai di indeks left sama dengan nilai di indeks left + 1 atau indeks setelahnya
                    while(left < nums.length - 1 && nums[left] == nums[left+1]) {
                        // memindahkan indeks kekanan
                        left++;
                    }
                    // memindahkan lagi indeks kekanan
                    left++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode15 lc = new Leetcode15();
        int[] nums = {0,0,0};
        List<List<Integer>> result = lc.threeSum(nums);
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
