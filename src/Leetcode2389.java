import java.util.Arrays;

public class Leetcode2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        // inisialisasi nilai n dan m
        int n = nums.length;
        int m = queries.length;
        // membuat array result dengan panjang m
        int [] result = new int[m];

        // Melakukan sorting pada array nums
        Arrays.sort(nums);
        // Melakukan array ke stream of integer yang dapat dioperasikan ke dalam elemen array
        // menghitung jumlah semua elemen array
        int sum = Arrays.stream(nums).sum();

        // mengiterasi nilai array queries
        for(int i = 0; i < m; i++) {
            // inisiaslisasi nilai j dengan n - 1
            int j = n - 1;
            // inisialisasi nilai currentSum dengan nilai sum
            int currentSum = sum;
            // selama nilai j lebih besar dari 0 dan nilai currentSum lebih besar dari nilai queries[i]
            while(j >= 0 && currentSum > queries[i]) {
                // kurangi nilai currentSum dengan nilai nums[j] akan terus mengurangi 
                // nilai currentSum dengan nilai nums[j] sampai nilai currentSum lebih kecil dari nilai queries[i]
                // bertujuan untuk memastikan currentSum sekarang lebih kecil dari nilai queries[i]
                currentSum -= nums[j];
                // kurangi nilai j
                j--;
            }

            // memasukkan nilai j + 1 ke dalam array result
            result[i] = j + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode2389 leetcode2389 = new Leetcode2389();
        int[] nums = {4,5,2,1};
        int[] queries = {3,10,21};
        System.out.println(Arrays.toString(leetcode2389.answerQueries(nums, queries)));
    }
}
