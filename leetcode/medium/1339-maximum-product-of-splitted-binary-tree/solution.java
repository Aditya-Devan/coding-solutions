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
    private long total;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        total = sum(root);
        long max = max(root);
        return (int) (max % MOD);
    }

    public long max(TreeNode root) {
        if (root == null) return 0;

        long ans = 0;

        if (root.left != null) {
            long leftSum = root.left.val;
            ans = Math.max(ans, (total - leftSum) * leftSum);
        }

        if (root.right != null) {
            long rightSum = root.right.val;
            ans = Math.max(ans, (total - rightSum) * rightSum);
        }

        long left = max(root.left);
        long right = max(root.right);

        return Math.max(ans, Math.max(left, right));
    }

    public int sum(TreeNode root) {
        if (root == null) return 0;

        int left = sum(root.left);
        int right = sum(root.right);

        root.val += left + right;
        return root.val;
    }
}