import java.util.Stack;

public class Leetcode232 {
    Stack<Integer> stack1, stack2;

    public Leetcode232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    
    public int pop() {
        int temp = stack2.pop();
        return temp;
    }
    
    public int peek() {
        int temp = stack2.peek();
        return temp;
    }
    
    public boolean empty() {
        if(stack2.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode232 leetcode232 = new Leetcode232();
        leetcode232.push(1);
        leetcode232.push(2);
        System.out.println(leetcode232.peek());
        System.out.println(leetcode232.pop());
        System.out.println(leetcode232.empty());
    }
}
