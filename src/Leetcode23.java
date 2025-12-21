import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode23 {
    public ListNode23 mergeKLists(ListNode23[] lists) {

        PriorityQueue<ListNode23> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode23 dummyHead = new ListNode23(0);
        ListNode23 current = dummyHead;

        for(ListNode23 node : lists) {
            if(node != null) {
                heap.offer(node);
            }
        }

        while(!heap.isEmpty()) {
            ListNode23 smallestNode = heap.poll();
            current.next = smallestNode;
            current = current.next;
            if(smallestNode.next != null) {
                heap.offer(smallestNode.next);
            }
        }

        return dummyHead.next;
    }
}

class ListNode23 {
     int val;
     ListNode23 next;
     ListNode23() {}
     ListNode23(int val) { this.val = val; }
     ListNode23(int val, ListNode23 next) { this.val = val; this.next = next; }
}