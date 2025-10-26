public class Leetcode98 {
    public boolean isValidBST(TreeNode root) {
        int prev = Integer.MIN_VALUE;
        if (root == null) {
            return true;
        }

        return helperBST(root, new int[]{prev}, new boolean[]{false});
    }

    private boolean helperBST(TreeNode node, int[] prev, boolean[] isPrevSet) {
        if (node == null) {
            return true;
        }

        if (!helperBST(node.left, prev, isPrevSet)) {
            return false;
        }

        if (isPrevSet[0] && node.val <= prev[0]) {
            return false;
        }

        prev[0] = node.val;
        isPrevSet[0] = true;

        return helperBST(node.right, prev, isPrevSet);
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
