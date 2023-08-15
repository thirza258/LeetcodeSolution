public class Leetcode222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = 0;
        int rightCount = 0;

        TreeNode leftNode = root;
        TreeNode rightNode = root;

        while (leftNode != null) {
            leftCount++;
            leftNode = leftNode.left;
        }

        while(rightNode != null) {
            rightCount++;
            rightNode = rightNode.right;
        }

        if (leftCount == rightCount) {
            int count = (int) Math.pow(2, leftCount) - 1;
            return count;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
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
