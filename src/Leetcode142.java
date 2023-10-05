public class Leetcode142 {
    ListNode p1;
    ListNode p2;

    public ListNode detectCycle(ListNode head) {
       if(hasCycle(head) == false) {
            return null;
       }

       p1 = head;
       while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
       }

       return p1;
    }

    // untuk mengecek apakah ada cycle atau tidak
    public boolean hasCycle(ListNode head) {
        // jiika head null, maka tidak ada cycle
        if(head == null) {
            return false;
        }
        // inisiasi p1 dan p2
        p1=head;
        p2=head;

        // iterasi selama p1 dan p2 tidak null
        while(p1 != null && p2 != null) {
            // mengambil p1.next
            p1 = p1.next;
            // jika p2 tidak null, maka p2.next adalah p2.next.next
            if(p2.next == null) {
                return false;
            }
            p2 = p2.next.next;
            // Jika bertemu kembali maka ada cycle
            if(p1 == p2) {
                return true;
            }
        }
        return false;
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
