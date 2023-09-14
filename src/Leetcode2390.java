import java.util.Stack;

public class Leetcode2390 {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if(stack.size() == 0) {
            return "";
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Leetcode2390 lc = new Leetcode2390();
        String s = "leet**cod*e";
        System.out.println(lc.removeStars(s));
    }
}
