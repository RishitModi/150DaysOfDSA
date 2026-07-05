class Solution {
    int ans = 0;

    private int height(TreeNode root) {
        if (root == null) return 0;

        int leftHt = height(root.left);
        int rightHt = height(root.right);

        ans = Math.max(ans, leftHt + rightHt);

        return 1 + Math.max(leftHt, rightHt);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return ans;
    }
}