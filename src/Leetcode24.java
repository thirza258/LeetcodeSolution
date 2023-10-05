public class Leetcode24 {
    public ListNode swapPairs(ListNode head) {
        // membuat node dengan null
        ListNode temp = null;
        // untuk setiap node, jika node tidak null dan node.next tidak null, maka
        for(ListNode p = head; p != null && p.next != null; p = p.next) {
            // t adalah node setelah p 
            ListNode t = p.next;
            // p.next adalah node setelah t.next
            p.next = t.next;
            // t.next adalah p
            t.next = p;
            // jika temp tidak null, maka temp.next adalah t
            if(temp != null) {
                temp.next = t;
            } 
            // temp adalah p;
            temp = p;
            // jika head adalah p, maka head adalah t
            if(head == p) {
                head = t;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Leetcode24 lc = new Leetcode24();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode tail = new ListNode(4);
        ListNode tail2 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = tail;
        tail.next = tail2;

        ListNode temp = lc.swapPairs(head);
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int x) {
        this.val = x;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
}
