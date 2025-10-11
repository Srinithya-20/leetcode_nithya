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
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root,root);
    }
    public boolean isEqual(TreeNode left, TreeNode right) {
        if (left==null&&right==null) return true;
        else if (left==null || right == null || left.val!=right.val) return false;
        else return isEqual(left.left,right.right)&&isEqual(left.right,right.left);
    }
} 