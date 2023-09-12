public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode headFirst = head;
        ListNode headSecond = head.next;

        while(headSecond != null && headSecond.next != null) {
            headFirst = headFirst.next;
            headSecond = headSecond.next.next;
        }

        ListNode middle = headFirst.next;
        headFirst.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(middle);
        return helper(left, right);
    }

    private ListNode helper(ListNode headFirst, ListNode headSecond) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (headFirst != null && headSecond != null) {
            if (headFirst.val < headSecond.val) {
                tail.next = headFirst;
                headFirst = headFirst.next;
            } else {
                tail.next = headSecond;
                headSecond = headSecond.next;
            }
            tail = tail.next;
        }

        if (headFirst != null) {
            tail.next = headFirst;
        } else {
            tail.next = headSecond;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Leetcode148 lc = new Leetcode148();
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = null;
        ListNode result = lc.sortList(head);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}