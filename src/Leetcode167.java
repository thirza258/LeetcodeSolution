import java.util.ArrayList;
import java.util.List;

public class Leetcode167 {
    public int[] twoSum(int[] numbers, int target) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[2];

        int low = 0;
        int high = numbers.length - 1;

        while(low < high) {
            if(numbers[low] + numbers[high] == target) {
                list.add(low + 1);
                list.add(high + 1);

                for(int i = 0; i < list.size(); i++) {
                    result[i] = list.get(i);
                }

                return result;
            }
            else {
                if(numbers[low] + numbers[high] > target) {
                    high--;
                }
                else {
                    low++;
                }
            }
        }

        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Leetcode167 lc = new Leetcode167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = lc.twoSum(numbers, target);
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
