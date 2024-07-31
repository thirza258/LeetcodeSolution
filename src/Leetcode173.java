import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode173 {
    private List<Integer> v = new ArrayList<>();
    private int position = 0;

    public Leetcode173(TreeNode root) {
        position = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                v.add(root.val);
                root = root.right;
            }
        }
    }
    
    public int next() {
        return v.get(position++);
    }
    
    public boolean hasNext() {
        return position < v.size();
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(20);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        Leetcode173 leetcode173 = new Leetcode173(node1);
        System.out.println(leetcode173.next());
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
 TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
        this.left = left;
     this.right = right;
}
}
