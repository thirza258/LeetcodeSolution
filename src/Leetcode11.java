public class Leetcode11 {
    /*
     * 11. Container With Most Water
     */
    public int maxArea(int[] height) {
        // inisiasi variabel maxArea untuk menyimpan luas maksimal
        int maxArea = 0;

        // inisiasi variabel low dan high untuk menyimpan indeks dari array height
        int low = 0;
        int high = height.length - 1;

        // inisiasi variabel area untuk menyimpan luas
        int area = Integer.MIN_VALUE;

        // selama indeks low kurang dari indeks high
        while(low < high) {
            // jika nilai di indeks low lebih kecil dari nilai di indeks high
            if(height[low] < height[high]) {
                // maka luas adalah (high - low) * nilai di indeks low
                area = (high - low) * height[low];
                do {
                    // tambah indeks low selama nilai indexs low kurang dari  indeks high 
                    // dan nilai di nilai di indeks low lebih besar sama dengan nilai di indeks low - 1 atau indeks sebelumnya
                    low++;
                } while(low < high && height[low - 1] >= height[low]);
            }
            else {
                // area adalah (high - low) * nilai di indeks high
                area = (high - low) * height[high];
                do{
                    // kurangi indeks high selama nilai indeks high lebih besar dari indeks low
                    // dan nilai di indeks high high + 1 atau indeks setelahnya lebih besar sama dengan nilai di indeks high
                    high--;
                } while(high > low && height[high + 1] >= height[high]);
            }

            // jika area lebih besar dari maxArea
            if(area > maxArea) {
                // maka maxArea adalah area
                maxArea = area;
            }

        }

        return maxArea;

    }

    public static void main(String[] args) {
        Leetcode11 lc = new Leetcode11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(lc.maxArea(height));
    }
}
