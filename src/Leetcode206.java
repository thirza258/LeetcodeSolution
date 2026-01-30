public class Leetcode206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = head;

        while(current != null) {
            ListNode nextNode = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = nextNode;
        }

        return dummy.next;
    }
}
