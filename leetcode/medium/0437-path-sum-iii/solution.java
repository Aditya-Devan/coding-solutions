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
int total = 0;
public int pathSum(TreeNode root, int sum) {
if (root == null)
return 0;
HashMap<Long, Integer> hm = new HashMap<>();
hm.put(0L, 1);
findPathSum(root, 0L, sum, hm);
return total;

}

private void findPathSum(TreeNode curr, long sum, int target,
                         HashMap<Long, Integer> hm) {

    if (curr == null)
        return;

    sum += curr.val;

    if (hm.containsKey(sum - target))
        total += hm.get(sum - target);

    hm.put(sum, hm.getOrDefault(sum, 0) + 1);

    findPathSum(curr.left, sum, target, hm);
    findPathSum(curr.right, sum, target, hm);

    hm.put(sum, hm.get(sum) - 1);
}

}