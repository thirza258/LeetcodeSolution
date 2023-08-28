public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        temp1 = temp2 = head;

        for(int i = 0; i < n; i++) {
            if(temp2 == null) {
                return null;
            }
            temp2 = temp2.next;
        }

        while(temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        temp1.next = temp1.next.next;
        return head.next;
    }

    public static void main(String[] args) {
        Leetcode19 lc = new Leetcode19();
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i = 2; i <= 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode result = lc.removeNthFromEnd(head, 2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class ListNode {
   int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
         this.val = val; 
    }

    ListNode(int val, ListNode next) {
         this.val = val; 
         this.next = next; 
    }
}
