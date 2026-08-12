# Binary Tree Zigzag Level Order Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the `root` of a binary tree, return  *the zigzag level order traversal of its nodes' values*. (i.e., from left to right, then right to left for the next level and alternate between).

 

 **Example 1:** 

```
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

```

 **Example 2:** 

```
Input: root = [1]
Output: [[1]]

```

 **Example 3:** 

```
Input: root = []
Output: []

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [0, 2000].
- -100 <= Node.val <= 100

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 79.73%)  
**Memory:** 43.5 MB (beats 80.47%)  
**Submitted:** 2026-08-12T16:59:29.310Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)