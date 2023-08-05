public class Leetcode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // membuat dummy node
        ListNode listNodeDummy = new ListNode(0);

        // mengassign dummy node sebagai head dari list dan next dari dummy node adalah list1
        listNodeDummy.next = list1;
        ListNode prev = listNodeDummy;

        // While list 1 dan list 2 masih ada isinya
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                // jika list1 lebih kecil dari list2, maka prev akan menjadi list1
                prev = list1;
                // list1 akan menjadi list1.next
                list1 = list1.next;
            } else {
                // jika list2 lebih kecil dari list1
                //dibuat list node temporary untuk menyimpan list2.next
                ListNode temp = list2.next;
                // list1 di samping head akan menjadi list2 
                prev.next = list2;
                // list2 next akan menjadi list1
                list2.next = list1;
                // prev akan menjadi list2
                prev = list2;
                list2 = temp;
            }
        }

        if (list2 != null) {
            prev.next = list2;
        }

        return listNodeDummy.next;
    }

    public static void main(String[] args) {
        Leetcode21 lc = new Leetcode21();
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = lc.mergeTwoLists(list1, list2);
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
