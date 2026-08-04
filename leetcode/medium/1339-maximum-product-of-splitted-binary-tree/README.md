# Maximum Product of Splitted Binary Tree

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the `root` of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.

Return  *the maximum product of the sums of the two subtrees*. Since the answer may be too large, return it  **modulo**  `109 + 7`.

 **Note**  that you need to maximize the answer before taking the mod and not after taking it.

 

 **Example 1:** 

```
Input: root = [1,2,3,4,5,6]
Output: 110
Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)

```

 **Example 2:** 

```
Input: root = [1,null,2,3,4,null,null,5,6]
Output: 90
Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [2, 5 * 104].
- 1 <= Node.val <= 104

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 87.23%)  
**Memory:** 63.2 MB (beats 68.57%)  
**Submitted:** 2026-08-04T07:58:30.130Z  

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
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/)