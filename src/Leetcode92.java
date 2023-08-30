public class Leetcode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode begin = dummy;
        ListNode end = dummy;

        int distance = right - left;
        while (end != null && distance > 0) {
            end = end.next;
            distance--;
        }

        while (left > 1) {
            begin = begin.next;
            end = end.next;
            left--;
        }

        if(begin == null || end == null || end.next == null) {
            return head;
        }

        ListNode temp1 = begin.next;
        ListNode temp2 = end.next.next;

        ListNode headTemp = temp2;
        while(temp1 != temp2) {
            ListNode node = temp1.next;
            temp1.next = headTemp;
            headTemp = temp1;
            temp1 = node;
        }

        begin.next = headTemp;

        return dummy.next;
    }

    public static void main(String[] args) {
        Leetcode92 lc = new Leetcode92();
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i = 2; i <= 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode result = lc.reverseBetween(head, 2, 4);
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