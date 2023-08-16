import java.util.Stack;

public class Leetcode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            if(chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
                stack.push(chars[i]);
            }
            else if(chars[i] == '}' || chars[i] == ']' || chars[i] == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                char cTop = stack.pop();
                if((cTop == '{' && chars[i] == '}') || (cTop == '[' && chars[i] == ']') || (cTop == '(' && chars[i] == ')')) {
                    continue;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Leetcode20 lc = new Leetcode20();
        String s = "()[]{}";
        System.out.println(lc.isValid(s));
    }
}
