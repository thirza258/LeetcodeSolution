import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List; // Add this import statement


public class Leetcode224 {
    public int prec(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return 0;
        }
    }

    public char associativity(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return 'L';
        } else {
            return 'N';
        }
    }

    public int calculate(String s) {
        StringBuilder sb = new StringBuilder(); 
        Deque<Character> stack = new ArrayDeque<>();
        boolean expectNumber = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c == '(') {
                stack.push(c);
                expectNumber = true;
            } else if (c == ')') {
                while (stack.peek() != '(') {
                    sb.append(stack.pop()).append(' ');
                }
                stack.pop();
            } else if (Character.isDigit(c)) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append(' ');
                i--;
                expectNumber = false;
            } else {
                if (c == '-' && expectNumber) {
                    sb.append('0').append(' ');
                }
                while (!stack.isEmpty() && (prec(c) < prec(stack.peek()) ||
                                            (prec(c) == prec(stack.peek()) &&
                                             associativity(c) == 'L'))) {
                    sb.append(stack.pop()).append(' ');
                }
                stack.push(c);
                expectNumber = true;
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        
        String postfix = sb.toString().trim();
        Deque<Integer> evalStack = new ArrayDeque<>();
        String[] tokens = postfix.split("\\s+");
        
        for (String token : tokens) {
            if (token.matches("-?\\d+")) { // Handle negative numbers as well
                evalStack.push(Integer.parseInt(token));
            } else {
                int operand2 = evalStack.pop();
                int operand1 = evalStack.pop();
                int result = 0;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                }

                evalStack.push(result);
            }
        }

        return evalStack.pop();
    }
    
    public static void main(String[] args) {
        Leetcode224 sol = new Leetcode224();
        System.out.println(sol.calculate("2147483647")); // Expected output: 2147483647
    }
}
