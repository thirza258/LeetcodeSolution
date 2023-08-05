public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // membuat node baru dan variabel support
        ListNode head = null;
        ListNode t = head;
        int sum = 0; 
        int carry = 0;
        int x = 0;
        int y = 0;

        // Jika salah satu dari l1 atau l2 tidak null, maka lakukan perulangan
        while (l1 != null || l2 != null) {
            // Jika l1 tidak null, maka x = l1.val atau isi dari l1 dan l1 akan menjadi listNOde selanjutnya
            //, jika l1 null, maka x = 0
            if(l1 != null) {
                x = l1.val;
                l1 = l1.next;
            } else {
                x = 0;
            }
            // Jika l2 tidak null, maka y = l2.val atau isi dari l2 dan l2 akan menjadi listNOde selanjutnya
            //, jika l2 null, maka y = 0
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            } else {
                y = 0;
            }

            // hasil dari penjumlahan x + y + carry atau kolom atau listnode yang "seindex"
            sum = x + y + carry;

            // membuat listnode baru dengan isi dari sum % 10 atau sisa bagi sum dengan 10
            ListNode node = new ListNode(sum % 10);
            //Jika head null, maka head menjadi node hasil sisa bagi dengan 10 dan t menjadi head atau list dari head
            if(head == null) {
                head = node;
                t = head;
            }
            // jika head tidak null, maka t.next = node dan t sekarang menjadi node selanjutnya
            else {
                t.next = node;
                t = t.next;
            }

            // carry = sum / 10 atau hasil bagi sum dengan 10
            carry = sum / 10;
        }

        // jika carry lebih dari 0, maka buat listnode baru dengan isi carry dan t.next = node atau listnode baru
        if(carry > 0) {
            ListNode node = new ListNode(carry);
            t.next = node;
        }

        return head;
    }

    public static void main(String[] args) {
        Leetcode2 leetcode2 = new Leetcode2();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6));
        ListNode result = leetcode2.addTwoNumbers(l1, l2);
        System.out.print(result.val + "," + result.next.val + ","+  result.next.next.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }