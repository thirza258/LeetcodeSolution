import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode150 {
    public int evalRPN(String[] tokens) {
        boolean error = false;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < tokens.length && !error; i++) {
            if(isDigit(tokens[i])) {
                stack.add(Integer.parseInt(tokens[i]));
            }
            else if(isOperator(tokens[i])) {
                if(stack.size() < 2) {
                    return 0;
                }
                
                int lhs = 0;
                int rhs = 0;
                if (!stack.isEmpty()) {
                    rhs = stack.remove(stack.size() - 1);
                }
                if (!stack.isEmpty()) {
                    lhs = stack.remove(stack.size() - 1);
                }

                int evalValue = 0;
                if(tokens[i].equals("+")) {
                    evalValue = lhs + rhs;
                }
                else if(tokens[i].equals("-")) {
                    evalValue = lhs - rhs;
                }
                else if(tokens[i].equals("*")) {
                    evalValue = lhs * rhs;
                }
                else if(tokens[i].equals("/")) {
                    evalValue = lhs / rhs;
                }

                stack.add(evalValue);
            } else {
                return 0;
            }
        }

        if(stack.size() != 1) {
            return 0;
        }

        return stack.get(stack.size() - 1);
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean isDigit(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void main(String[] args) {
        Leetcode150 leetcode150 = new Leetcode150();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(leetcode150.evalRPN(tokens));
    }
}
