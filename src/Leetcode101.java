import java.util.LinkedList;
import java.util.Queue;

public class Leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode lRoot, TreeNode rRoot) {
        Queue<TreeNode> lQueue = new LinkedList<>();
        Queue<TreeNode> rQueue = new LinkedList<>();

        lQueue.add(lRoot);
        rQueue.add(rRoot);

        while(lQueue.size() > 0 && rQueue.size() > 0) {
            TreeNode lNode = lQueue.poll();
            TreeNode rNode = rQueue.poll();

            if(lNode == null && rNode == null) {
                continue;
            }

            if(lNode == null || rNode == null) {
                return false;
            }

            if(lNode.val != rNode.val) {
                return false;
            }

            lQueue.add(lNode.left);
            lQueue.add(lNode.right);

            rQueue.add(rNode.right);
            rQueue.add(rNode.left);
        }

        return true;
    }

    public static void main(String[] args) {
        Leetcode101 leetcode101 = new Leetcode101();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = null;
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = null;
        TreeNode node6 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left  = node5;
        node2.right = node6;
        System.out.println(leetcode101.isSymmetric(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
         this.val = val; 
        }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}