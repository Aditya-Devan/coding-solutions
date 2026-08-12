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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
          if (root == null) return ans;
          Queue<TreeNode> queue = new LinkedList<>();
           queue.add(root);
           int level = 0;

          while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            List<Integer> ls=new ArrayList<>();
          
if (level % 2 == 1) {
    for (int i = currentLevel.size() - 1; i >= 0; i--) {
        ls.add(currentLevel.get(i).val);
    }
} else {
    for (int i = 0; i < currentLevel.size(); i++) {
        ls.add(currentLevel.get(i).val);
    }
}
            ans.add(ls);

            level++;
        }
 return ans;

    }
}