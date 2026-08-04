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