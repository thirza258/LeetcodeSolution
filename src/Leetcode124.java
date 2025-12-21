public class Leetcode124 {
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] maxSum = new int[]{Integer.MIN_VALUE};

        postOrderHelper(root, maxSum);

        if(root != null) {
            maxSum[0] = Math.max(maxSum[0], root.val);
        }

        return maxSum[0];


    }

    private int postOrderHelper(TreeNode node, int[] maxSum) {
        if(node == null) {
            return 0;
        }

        int leftGain = Math.max(0, postOrderHelper(node.left, maxSum));
        int rightGain = Math.max(0, postOrderHelper(node.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], leftGain + rightGain + node.val);

        return Math.max(leftGain, rightGain) + node.val;
    }


}
