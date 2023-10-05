import java.util.List;

public class Leetcode86 {
    public ListNode partition(ListNode head, int x) {
        // Jika head null, return null
        if(head == null) {
            return null;
        }

        // membuat dummy node di paling depan
        ListNode left = new ListNode(0);
        left.next = head;
        head = left;


        // posisi untuk node yang akan diinsert
        ListNode position = null;
        // Untuk i = head, jika i tidak null dan i.next tidak null, maka
        for(ListNode i = head; i != null && i.next != null;) {
            // Jika posisi null dan i.next >= x, maka posisi adalah node sekarang, dan lanjut
            if(position == null && i.next.val >= x) {
                position = i;
                i = i.next;
                continue;
            }
            // Jika posisi tidak null dan disamping posisi ada node yang < x, maka
            if(position != null && i.next.val < x ) {
                // Buat temp2 untuk menyimpan node yang akan diinsert
                ListNode temp2 = i.next;
                // i.next adalah node melompat node yang diambil
                i.next = i.next.next;
                // temp2.next adalah posisi setelah position.next yang lebih dari x
                temp2.next = position.next;
                // position.next adalah temp2
                position.next = temp2;
                // position adalah posisi setelah temp2 atau ambil node yang baru diinsert
                position = position.next;
                continue;
            }
            i = i.next;
        }
        return head.next;

    }

    public static void main(String[] args) {
        Leetcode86 lc = new Leetcode86();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode tail = new ListNode(5);
        ListNode tail2 = new ListNode(2);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = tail;
        tail.next = tail2;

        ListNode temp = lc.partition(head, 3);
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
