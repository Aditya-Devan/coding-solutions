# Binary Tree Cameras

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You are given the `root` of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return  *the minimum number of cameras needed to monitor all nodes of the tree*.

 

 **Example 1:** 

```
Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.

```

 **Example 2:** 

```
Input: root = [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

```

 

 **Constraints:** 

- The number of nodes in the tree is in the range [1, 1000].
- Node.val == 0

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 44.9 MB (beats 28.44%)  
**Submitted:** 2026-08-17T16:32:40.728Z  

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
    int ans;
    public int minCameraCover(TreeNode root) {
      if(camreq(root)==-1) ans++;
      return ans;
    }

    public int camreq(TreeNode root){
     if(root==null) return 1;

     int lef=camreq(root.left);
     int righ=camreq(root.right);

     if(lef==-1 || righ==-1){
        ans++;
        return 0;
     }

     if(lef==0 || righ==0) return 1;

     return -1;

    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/binary-tree-cameras/)