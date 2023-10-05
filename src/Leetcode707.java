public class Leetcode707 {
    int size = 0;
    ListNode head = null;
    ListNode tail = null;

    public Leetcode707() {
        
    }
    
    public int get(int index) {
        if(index >= size) {
            return -1;
        }
        ListNode temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        if(size == 0) {
            tail = node;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if(size == 0) {
            addAtHead(val);
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        } else if(index == size) {
            addAtTail(val);
        } else if(index == 0) {
            addAtHead(val);
        } else {
            ListNode temp = head;
            ListNode node = new ListNode(val);
            for(int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) {
            return;
        } else if(index == size - 1) {
            if(index == 0) {
                head = null;
                tail = null;
            }
            else {
                ListNode temp = head;
                while(temp.next != tail) {
                    temp = temp.next;
                }
                tail = temp;
                temp.next = null;
            }
        }
        else if(index == 0) {
            ListNode temp = head;
            head = head.next;
            temp = null;
        }
        else {
            ListNode temp = head;
            for(int i = 0; i < index - 1; ++i) {
                temp = temp.next;
            }
            ListNode temp2 = temp.next;
            temp.next = temp.next.next;
            temp2.next = null;
        }
        size--;
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
