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