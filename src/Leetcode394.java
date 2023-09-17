import java.util.Stack;

public class Leetcode394 {
    public String decodeString(String s) {
        // Inisialisasi stack untuk menyimpan string dan integer
        Stack<String> stack = new Stack<>();
        Stack<Integer> integers = new Stack<>();

        // Inisialisasi string builder untuk menyimpan hasil
        StringBuilder sb = new StringBuilder();
        String temp;

        int n = 0;
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                n = 0;
                for(; Character.isDigit(s.charAt(i)); i++) {
                    n = n * 10 + s.charAt(i) - '0';
                }
            }
            if(s.charAt(i) == '[') {
                temp = "";
                stack.push(temp);
                integers.push(n);
            }
            else if(s.charAt(i) == ']') {
                n = integers.peek();
                temp = "";
                for(; n > 0; n--) {
                    temp += stack.peek();
                }
                stack.pop();
                integers.pop();
                if(!stack.isEmpty()) {
                    String c = stack.peek();
                    c += temp;
                    stack.pop();
                    stack.push(c);
                }else {
                    sb.append(temp);
                }
            }
            else {
                if(!stack.isEmpty()) {
                    String c = stack.peek();
                    c += s.charAt(i);
                    stack.pop();
                    stack.push(c);
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode394 lc = new Leetcode394();
        String s = "3[a]2[bc]";
        System.out.println(lc.decodeString(s));
    }
}
