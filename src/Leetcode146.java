import java.util.HashMap;
import java.util.Map;

public class Leetcode146 {
    int capacity;
    Map<Integer, ListNode> map = new HashMap<>();
    DoublyLinkedList dll = new DoublyLinkedList();

    public Leetcode146(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            dll.TakeToBeginning(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            ListNode p = map.get(key);
            p.value = value;
            dll.TakeToBeginning(map.get(key));
        }else {
            map.put(key, dll.insertHead(key, value));

            if(dll.getSize() > capacity) {
                int keys = dll.getTail().key;
                map.remove(keys);
                dll.DeleteTail();
            }
        }
    }
}

class DoublyLinkedList {
    ListNode head;
    ListNode tail;
    int size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }
   
    public int getSize() {
        return size;
    }

    public ListNode insertHead(int key, int value) {
        ListNode n = new ListNode(key, value);
        return addToHead(n);
    }

    public ListNode addToHead(ListNode n) {
        size++;

        if(head == null) {
            head = tail = n;
            return n;
        }

        n.next = head;
        n.prev = null;
        head.prev = n;
        head = n;
        return n;
    }

    public ListNode InsertTail(int key, int value) {
        ListNode n = new ListNode(key, value);
        return addToTail(n);
    }

    public ListNode addToTail(ListNode n) {
        size++;

        if(head == null) {
            head = tail = n;
            return n;
        }

        tail.next = n;
        n.prev = tail;
        n.next = null;
        tail = n;
        return n;
    }

    public void Unlink(ListNode n) {
        ListNode before = n.prev;
        ListNode after = n.next;

        if(before != null) {
            before.next = after;
        } 
        if(after != null) {
            after.prev = before;
        }
        if(head == n) {
            head = head.next;
        }

        else if(tail == n) {
            tail = tail.prev;
        }

        size--;
    }

    void Delete(ListNode n) {
        Unlink(n);
        n = null;
    }

    void TakeToBeginning(ListNode n) {
        Unlink(n);
        addToHead(n);
    }

    ListNode getTail() {
        return tail;
    }

    void DeleteTail() {
        Delete(tail);
    }
}

class ListNode {
    int key;
    int value;
    ListNode next, prev;

    ListNode(int k, int v) {
        key=k;
        value=v;
        next=prev=null;
    }
}
