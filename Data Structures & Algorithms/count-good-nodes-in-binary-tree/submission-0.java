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
    int cnt = 0;
    private void helper(TreeNode node , int maxi){
        if(node.val >= maxi) cnt++;

        if(node.left!= null) helper(node.left , Math.max(maxi , node.left.val));
        if(node.right!= null) helper(node.right , Math.max(maxi , node.right.val));
    }
    public int goodNodes(TreeNode root) {
        helper(root , root.val);
        return cnt;    
    }
}
