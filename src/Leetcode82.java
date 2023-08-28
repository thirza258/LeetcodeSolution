public class Leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode tail = head;

        boolean duplicates = false;
        for(ListNode node = head.next; node != null && node.next != null; node = node.next) {
            if(duplicates == false && node.val == node.next.val) {
                duplicates = true;
                continue;
            }

            if(duplicates == true && node.val != node.next.val) {
                duplicates = false;
                tail.next = node.next;
                continue;
            }

            if(duplicates == false) {
                tail = tail.next;
            }
        }
        if(duplicates == true) {
            tail.next = null;
        }

        return head.next;
    }

    public static void main(String[] args) {
        Leetcode82 lc = new Leetcode82();
        ListNode head = new ListNode(1);
        ListNode node = head;
        for(int i = 2; i <= 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = new ListNode(5);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;
        ListNode result = lc.deleteDuplicates(head);
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
