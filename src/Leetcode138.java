public class Leetcode138 {
    public Node copyRandomList(Node head) {
        Node now = null;
        Node newHead = null;
        Node tail = null;

        if(head == null) {
            return null;
        }

        now = head;
        while(now != null) {
            Node newNode = new Node(now.val);
            newNode.next = now.next;
            now.next = newNode;
            now = newNode.next;
        }

        now = head;
        while(now != null) {
            if(now.random != null) {
                now.next.random = now.random.next;
            }
            now = now.next.next;
        }

        now = head;
        newHead = tail = head.next;
        while(now != null) {
            now.next = now.next.next;
            if(tail.next != null) {
                tail.next = tail.next.next;
            }

            now = now.next;
            tail = tail.next;
        }

        return newHead;

    }

    public static void main(String[] args) {
        Leetcode138 leetcode138 = new Leetcode138();
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        
        System.out.println(leetcode138.copyRandomList(head));
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public String toString() {
        return String.valueOf(val);
    }
}