public class Leetcode11 {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int low = 0;
        int high = height.length - 1;

        int area = Integer.MIN_VALUE;
        while(low < high) {
            if(height[low] < height[high]) {
                area = (high - low) * height[low];
                do {
                    low++;
                } while(low < high && height[low - 1] >= height[low]);
            }
            else {
                area = (high - low) * height[high];
                do{
                    high--;
                } while(high > low && height[high + 1] >= height[high]);
            }

            if(area > maxArea) {
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
