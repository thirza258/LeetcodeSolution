public class Leetcode530 {
    public int getMinimumDifference(TreeNode root) {
        int[] minimumDifference = new int[]{Integer.MAX_VALUE};
        int[] previousValue = new int[]{-1};

        helper(root, previousValue, minimumDifference);
        return minimumDifference[0];
    }

    private void helper(TreeNode root, int[] previousValue, int[] minimumDifference) {
        if(root == null) {
            return;
        }

        helper(root.left, previousValue, minimumDifference);
        if(previousValue[0] != -1) {
            minimumDifference[0] = Math.min(minimumDifference[0], root.val - previousValue[0]);
        }

        previousValue[0] = root.val;
        helper(root.right, previousValue, minimumDifference);
    }

    public static void main(String[] args) {
        Leetcode530 leetcode530 = new Leetcode530();
        TreeNode root = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
        System.out.println(leetcode530.getMinimumDifference(root));
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