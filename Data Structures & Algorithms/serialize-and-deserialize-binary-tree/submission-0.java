/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
                if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                sb.append("#,");
            } else {
                sb.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
 if (data.isEmpty()) return null;

        StringBuilder s = new StringBuilder(data);
        int idx = s.indexOf(",");
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, idx)));
        s.delete(0, idx + 1);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            idx = s.indexOf(",");
            String left = s.substring(0, idx);
            s.delete(0, idx + 1);
            if (!left.equals("#")) {
                node.left = new TreeNode(Integer.parseInt(left));
                q.offer(node.left);
            }

            idx = s.indexOf(",");
            String right = s.substring(0, idx);
            s.delete(0, idx + 1);
            if (!right.equals("#")) {
                node.right = new TreeNode(Integer.parseInt(right));
                q.offer(node.right);
            }
        }

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));