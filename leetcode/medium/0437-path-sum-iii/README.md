# Path Sum III

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the `root` of a binary tree and an integer `targetSum`, return  *the number of paths where the sum of the values along the path equals*  `targetSum`.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

 

 **Example 1:** 

```
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.

```

 **Example 2:** 

```
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [0, 1000].
- -109 <= Node.val <= 109
- -1000 <= targetSum <= 1000

## Solution

**Language:** Java  
**Runtime:** 3 ms (beats 98.04%)  
**Memory:** 46.3 MB (beats 47.77%)  
**Submitted:** 2026-08-05T16:06:56.301Z  

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
```

---

[View on LeetCode](https://leetcode.com/problems/path-sum-iii/)