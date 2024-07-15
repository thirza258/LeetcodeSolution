public class Leetcode117 {
    public Node connect(Node root) {
        if (root == null) return root;

        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }

        if (root.next != null) {
            Node left = null, right = null;
            left = (root.right != null) ? root.right : root.left;

            for (Node p = root.next; p != null; p = p.next) {
                if (p.left != null) {
                    right = p.left;
                    break;
                }
                if (p.right != null) {
                    right = p.right;
                    break;
                }
            }

            if (left != null) {
                left.next = right;
            }
        }

        connect(root.right);
        connect(root.left);

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
