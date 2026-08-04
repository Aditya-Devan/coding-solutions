# Construct Binary Tree from Preorder and Inorder Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given two integer arrays `preorder` and `inorder` where `preorder` is the preorder traversal of a binary tree and `inorder` is the inorder traversal of the same tree, construct and return  *the binary tree*.

 

 **Example 1:** 

```
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

```

 **Example 2:** 

```
Input: preorder = [-1], inorder = [-1]
Output: [-1]

```

 

 **Constraints:** 

- 1 <= preorder.length <= 3000
- inorder.length == preorder.length
- -3000 <= preorder[i], inorder[i] <= 3000
- preorder and inorder consist of unique values.
- Each value of inorder also appears in preorder.
- preorder is guaranteed to be the preorder traversal of the tree.
- inorder is guaranteed to be the inorder traversal of the tree.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 97.33%)  
**Memory:** 46.5 MB (beats 25.12%)  
**Submitted:** 2026-08-04T05:32:06.264Z  

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
    private int preIndex = 0;
    private Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
          for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder , int si , int ei){
         if(si>ei ) return null;
 
         int rootVal=preorder[preIndex++];
         TreeNode root = new TreeNode(rootVal);

         int inIndex = inMap.get(rootVal);
         
        root.left  = build(preorder, si, inIndex - 1);
        root.right = build(preorder, inIndex + 1,ei);

        return root;

    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)