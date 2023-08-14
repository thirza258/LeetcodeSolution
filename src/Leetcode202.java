import java.util.HashMap;
import java.util.Map;

public class Leetcode202 {
    public boolean isHappy(int n) {
        if (n==1) {
            return true;
        }

        Map<Integer, Boolean> map = new HashMap<>();
        map.put(n, true);

        while(n!=1) {
            n = helper(n);
            if(map.containsKey(n)) {
                return false;
            }
            map.put(n, true);
        }
        return true;
    }

    private int helper(int n) {
        int result = 0;
        int square = 0;
        for(; n > 0; n/=10) {
            square = n % 10;
            result += (square * square);
        }
        return result;
    }

    public static void main(String[] args) {
        Leetcode202 leetcode202 = new Leetcode202();
        System.out.println(leetcode202.isHappy(19));
    }
}
