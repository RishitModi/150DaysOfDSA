class Solution {
    int ans;
    int k;  // RIGHT: shared across all recursive calls

    void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);
        k--;

        if (k == 0) {
            ans = root.val;
            return;
        }

        helper(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);

        return ans;
    }
}