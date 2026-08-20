/**

Approach 1: Convert to Graph via Parent Map (Easiest)Build Parent References:
 Do a quick DFS or BFS from root to store each node's parent in a HashMap (node -> parent).
 Graph Traversal: Treat each node as having up to 3 neighbors: left, right, and parent.
 BFS from Target: Run a standard BFS starting directly at target. 
 Expand outwards step-by-step up to distance $k$. Maintain a visited set so you don't loop back to nodes you've already processed.


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }


 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        populateParents(root, null, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        
        queue.offer(target);
        visited.add(target);

        int currentDistance = 0;

        while (!queue.isEmpty()) {
           
            if (currentDistance == k) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.offer(curr.left);
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.offer(curr.right);
                }

                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
            }
            currentDistance++;
        }

        return new ArrayList<>();
    }

    private void populateParents(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return;
        if (parent != null) {
            parentMap.put(node, parent);
        }
        populateParents(node.left, node, parentMap);
        populateParents(node.right, node, parentMap);
    }
}