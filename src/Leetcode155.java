import java.util.Stack;

public class Leetcode155 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin()); // Returns -3
        obj.pop();
        System.out.println(obj.top());    // Returns 0
        System.out.println(obj.getMin()); // Returns -2
    }
}

class MinStack {
    private Stack<Integer> stack;
    private Stack<int[]> minStack;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
            minStack.push(new int[]{val, 1});
        } else {
            if (val < min) {
                min = val;
                minStack.push(new int[]{val, 1});
            } else if (val == min) {
                minStack.peek()[1]++;
            }
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int val = stack.pop();
        if (val == minStack.peek()[0]) {
            if (minStack.peek()[1] == 1) {
                minStack.pop();
                if (!minStack.isEmpty()) {
                    min = minStack.peek()[0];
                } else {
                    min = Integer.MAX_VALUE;
                }
            } else {
                minStack.peek()[1]--;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
