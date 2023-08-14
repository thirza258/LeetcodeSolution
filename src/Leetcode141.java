import java.util.HashMap;
import java.util.Map;

public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> map = new HashMap<>();
        ListNode current = head;

        map.put(null, true);

        while(!map.containsKey(current)) {
            map.put(current, true);
            current = current.next;
        }
        return current != null;
    }

    public static void main(String[] args) {
        Leetcode141 leetcode141 = new Leetcode141();
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        leetcode141.hasCycle(head);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {       
         val = x;
         next = null;
      }
}