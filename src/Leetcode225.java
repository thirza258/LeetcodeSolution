import java.util.LinkedList;
import java.util.Queue;

public class Leetcode225 {
    private Queue<Integer> queue, queue2;


    public Leetcode225() {
        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if(queue.isEmpty()) {
            queue2.add(x);
        } else if(queue2.isEmpty()) {
            queue.add(x);
        }
    }
    
    public int pop() {
        if(!queue.isEmpty()) {
            while(queue.size() > 1) {
                queue2.add(queue.poll());
            }
            return queue.poll();
        }
        else if(!queue2.isEmpty()) {
            while(queue2.size() > 1) {
                queue.add(queue2.poll());
            }
            return queue2.poll();
        }
        else {
            return -1;
        }
    }
    
    public int top() {
        if(!queue.isEmpty()) {
            while(queue.size() > 1) {
                queue2.add(queue.poll());
            }
            int temp = queue.poll();
            queue2.add(temp);
            return temp;
        }
        else if(!queue2.isEmpty()) {
            while(queue2.size() > 1) {
                queue.add(queue2.poll());
            }
            int temp = queue2.poll();
            queue.add(temp);
            return temp;
        }
        else {
            return -1;
        }
    }
    
    public boolean empty() {
        if(queue.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        Leetcode225 leetcode225 = new Leetcode225();
        leetcode225.push(1);
        leetcode225.push(2);
        System.out.println(leetcode225.top());
        System.out.println(leetcode225.pop());
        System.out.println(leetcode225.empty());
    }
}
