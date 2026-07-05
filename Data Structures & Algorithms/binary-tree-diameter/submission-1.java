/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int ans = 0;

    private int height(TreeNode root){
        if(root ==null) return 0;
        int leftHt = height(root.left);
        int rightHt = height(root.right);
        return 1+Math.max(leftHt , rightHt);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int leftMax = height(root.left);
        int rightMax = height(root.right);
        ans = Math.max(leftMax + rightMax , ans);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return ans;
    }
}
