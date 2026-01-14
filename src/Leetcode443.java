public class Leetcode443 {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;

        while(read < chars.length) {
            int count = 0;
            char currentChar = chars[read];

            while(read < chars.length & currentChar == chars[read]) {
                count++;
                read++;
            }

            chars[write++] = currentChar;

            if(count > 1) {
                int temp = count;
                int digitsStart = 0;
                char[] digits = new char[chars.length];

                while(temp > 0) {
                    digits[digitsStart++] = (char) ('0' + (temp % 10));
                    temp /= 10;
                }

                for(int i = digitsStart - 1; i >= 0; i--) {
                    chars[write++] = (char)(digits[i]);
                }
            }
        }
        return write;
    }
}
