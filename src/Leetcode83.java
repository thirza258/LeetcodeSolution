public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }

        for(ListNode p = head; p != null && p.next != null;) {
            if(p.val == p.next.val) {
                p.next = p.next.next;
                continue;
            }

            if(p.next == null) {
                break;
            }

            p = p.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Leetcode83 lc = new Leetcode83();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode tail = new ListNode(3);
        ListNode tail2 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = tail;
        tail.next = tail2;

        ListNode temp = lc.deleteDuplicates(head);
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}
