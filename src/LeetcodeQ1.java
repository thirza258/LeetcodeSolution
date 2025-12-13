import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LeetcodeQ1 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache is {1=1}
        lruCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lruCache.get(1));    // return 1
        lruCache.put(3, 3); // evicts key 2, cache is {1=1, 3=3}
        System.out.println(lruCache.get(2));    // returns -1 (not found)
        lruCache.put(4, 4); // evicts key 1, cache is {4=4, 3=3}
        System.out.println(lruCache.get(1));    // return -1 (not found)
        System.out.println(lruCache.get(3));    // return 3
        System.out.println(lruCache.get(4));    // return 4
    }
}

class LRUCache {

    int capacity;
    DoublyLinkedListQ1 dll = new DoublyLinkedListQ1();
    HashMap<Integer, DoublyLinkedListNode> cache;

    public LRUCache(int capacity) {
        this.capacity  = capacity;
        this.cache = new HashMap<>();
        this.dll = new DoublyLinkedListQ1();
    }

    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        DoublyLinkedListNode node = cache.get(key);
        dll.removeNode(node);
        dll.addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            DoublyLinkedListNode node = cache.get(key);
            node.value = value;
            dll.removeNode(node);
            dll.addFirst(node);
            return;
        }

        if (cache.size() == capacity) {
            DoublyLinkedListNode last = dll.removeLast();
            cache.remove(last.key);
        }

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
        dll.addFirst(newNode);
        cache.put(key, newNode);
    }
}

class DoublyLinkedListNode {
    int key;
    int value;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }


    public DoublyLinkedListNode() {
    }
}


class DoublyLinkedListQ1 {
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;

    public DoublyLinkedListQ1() {
        head = new DoublyLinkedListNode();
        tail = new DoublyLinkedListNode();

        head.next = tail;

        tail.prev = head;
    }


    public void addFirst(DoublyLinkedListNode node) {
        DoublyLinkedListNode temp = head.next;

        node.next = temp;
        node.prev = head;

        head.next = node;
        temp.prev = node;
    }

    public void addLast(DoublyLinkedListNode node) {
        DoublyLinkedListNode temp = tail.prev;

        node.next = tail;
        node.prev = temp;

        tail.prev = node;
        temp.next = node;
    }

    public void removeNode(DoublyLinkedListNode node) {
        DoublyLinkedListNode prevNode = node.prev;
        DoublyLinkedListNode nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        node.prev = null;
        node.next = null;
    }


    public DoublyLinkedListNode removeLast() {
        if (tail.prev == head) {
            return null;
        }
        DoublyLinkedListNode lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
}

