import java.util.ArrayList;
import java.util.List;

public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }

        if(nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int middle = nums.length / 2;

        TreeNode root = new TreeNode(nums[middle]);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        List<Integer> leftTree = list.subList(0, middle);
        List<Integer> rightTree = list.subList(middle + 1, nums.length);

        root.left = sortedArrayToBST(leftTree.stream().mapToInt(i -> i).toArray());

        if(middle == nums.length - 1) {
            root.right = null;
        }
        else {
            root.right = sortedArrayToBST(rightTree.stream().mapToInt(i -> i).toArray());
        }

        return root;
    }

    

    public static void main(String[] args) {
        Leetcode108 lc = new Leetcode108();
        int[] nums = {-10,-3,0,5,9};
        TreeNode result = lc.sortedArrayToBST(nums);
        for(int i = 0; i < nums.length; i++) {
            if(result.right != null) {
                System.out.println(result.val);
                result = result.right;
            }
            if(result.left != null) {
                System.out.println(result.val);
                result = result.left;
            }
            else {
                System.out.println("null");
            }
        }
    }
}


// Definition for a binary tree node. 

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
