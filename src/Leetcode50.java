public class Leetcode50 {
    public double myPow(double x, int n) {
        boolean isNegative = n < 0;
        long exp = n;
        if(isNegative) {
            exp = -exp;
            isNegative = true;
        }
        double result = 1;
        while(exp > 0) {
            if (exp % 2 == 1) {
                result *= x;
            }
            x *= x;
            exp /= 2;
        }

        if (isNegative) {
            return 1 / result;
        }
        return result;
    }
}
