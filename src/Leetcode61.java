public class Leetcode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }

        // Untuk mulai dari node pertama
        // 1 -> 2 -> 3 -> 4 -> 5
        int len = 1;
        ListNode temp = head;
        // Mencari node ujung dari linked list
        // 1 -> 2 -> 3 -> 4 -> 5 <- ngambil 5
        while(temp.next != null) {
            len++;
            temp = temp.next;
        }

        // Jadiin linked list jadi circular atau node ujung ke node pertama
        // 1 -> 2 -> 3 -> 4 -> 5 -> 1
        temp.next = head;

        // untuk mencari node yang paling kiri yang akan jadi node terakhir
        // Cari 3
        k = len - k % len;

        // Untuk mencari node yang yang akan dijadikan akhir
        // 1 -> 2 -> 3 -> 4 -> 5 -> 1 <- ngambil 3
        for(int i = 0; i < k; i++) {
            temp = temp.next;
        }

        // Untuk mengambil node yang akan dijadikan head
        head = temp.next;
        // Untuk memutuskan node yang akan dijadikan head
        temp.next = null;

        return head;

    }

    public static void main(String[] args) {
        Leetcode61 lc = new Leetcode61();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode tail = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = tail;

        ListNode temp = lc.rotateRight(head, 2);
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