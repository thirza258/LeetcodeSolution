import java.util.LinkedList;
import java.util.Queue;

public class Leetcode933 {
    Queue<Integer> queue;

    public Leetcode933() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        int limit = t - 3000;
        queue.add(t);
        while(queue.peek() < limit) {
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        Leetcode933 lc = new Leetcode933();
        System.out.println(lc.ping(1));
        System.out.println(lc.ping(100));
        System.out.println(lc.ping(3001));
        System.out.println(lc.ping(3002));
    }
}
