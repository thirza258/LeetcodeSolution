public class Leetcode104 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return 1;
        }

        int left = 1;
        int right = 1;

        if(root.left != null) {
            left += maxDepth(root.left);
        }
        if(root.right != null) {
            right += maxDepth(root.right);
        }

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Leetcode104 leetcode104 = new Leetcode104();
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20); 
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2; 
        node2.left = node3;
        node2.right = node4;
        System.out.println(leetcode104.maxDepth(root));
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