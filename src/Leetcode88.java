public class Leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexArray1 = m - 1;
        int indexArray2 = n - 1;
        
        // iterasi dari belakang array 1
        for(int i = m+n-1; i>=0; i--) {
            // jika index array 1 sudah habis
            if(indexArray1 < 0) {
                // isi array 1 dengan index array 2 dan kurangi index array 2 dengan 1
                /*
                 * jadi ini kalau index array 1 udah abis jadi array 1 diisi dengan array 2
                 */
                nums1[i] = nums2[indexArray2--];
            } else if(indexArray2 < 0) {
                // jika index array 2 sudah habis maka isi array 1 dengan index array 1 dan kurangi index array 1 dengan 1
                nums1[i] = nums1[indexArray1--];
            // jika isi ujung dari array 1 lebih besar dari isi ujung dari array 2    
            } else if(nums1[indexArray1] > nums2[indexArray2]) {
                // memindahkan nilai array 1 ke ujung index array 1 dan kurangi index array 1
                nums1[i] = nums1[indexArray1--];
            } else {
                // isi array 1 dengan isi dari array 2 dan kurangi index array 1 
                // karena array 1 memiliki ukuran berlebih
                nums1[i] = nums2[indexArray2--];
            }
        }
    
    }

    public static void main(String[] args) {
        Leetcode88 leetcode88 = new Leetcode88();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        leetcode88.merge(nums1, 3, nums2, 3);
        for(int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
