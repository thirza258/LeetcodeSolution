public class Leetcode25 {
    public ListNode25 reverseKGroup(ListNode25 head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode25 dummy = new ListNode25(0);
        dummy.next = head;

        ListNode25 groupPrev = dummy;

        while(getKthNode(groupPrev, k) != null) {
            ListNode25 kthNode = getKthNode(groupPrev, k);

            ListNode25 nextGroupHead = kthNode.next;

            ListNode25 prev = nextGroupHead;
            ListNode25 curr = groupPrev.next;

            for(int i = 0; i < k; i++) {
                ListNode25 temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            ListNode25 prevGroupTail = groupPrev.next;
            groupPrev.next = kthNode;
            prevGroupTail.next = nextGroupHead;
            groupPrev = prevGroupTail;
        }

        return dummy.next;
    }

    ListNode25 getKthNode(ListNode25 start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}

class ListNode25 {
    int val;
    ListNode25 next;

    ListNode25() {}

    ListNode25(int val) {
        this.val = val;
    }

    ListNode25(int val, ListNode25 next) {
        this.val = val;
        this.next = next;
    }
}