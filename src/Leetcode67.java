public class Leetcode67 {
    public String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        boolean carry = false;
        StringBuilder result = new StringBuilder();

        while(lengthA > 0 || lengthB > 0) {
            int binaryA = 0;
            int binaryB = 0;
            int binaryCarry = 0;

            if(lengthA > 0) {
                binaryA = a.charAt(lengthA - 1) - '0';
            }
            else {
                binaryA = 0;
            }

            if(lengthB > 0) {
                binaryB = b.charAt(lengthB - 1) - '0';
            }else {
                binaryB = 0;
            }

            if(carry == true) {
                binaryCarry = 1;
            } else {
                binaryCarry = 0;
            }

            result.insert(0, (char) ('0' + ((binaryA + binaryB + binaryCarry) & 1)));
            carry = (binaryA + binaryB + binaryCarry) > 1 ;
            lengthA--;
            lengthB--;
        }

        if(carry) {
            result.insert(0, '1');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Leetcode67 leetcode67 = new Leetcode67();
        System.out.println(leetcode67.addBinary("11", "1"));
    }
}
