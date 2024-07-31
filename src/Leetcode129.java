// this code is just for fun, it's is a correct solution but it's not the best solution more effective with integer
public class Leetcode129 {
    public int sumNumbers(TreeNode root) {
        String result = preorder(root, "");
        return Integer.parseInt(result);
    }

    public String preorder(TreeNode root, String path) {
        if (root == null) {
            return "0";
        }

        path += root.val;
        if (root.left == null && root.right == null) {
            return path;
        }
        int result = Integer.parseInt(preorder(root.left, path)) + Integer.parseInt(preorder(root.right, path));
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        Leetcode129 leetcode129 = new Leetcode129();
        System.out.println(leetcode129.sumNumbers(node1));
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