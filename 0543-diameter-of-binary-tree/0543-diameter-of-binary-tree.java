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
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root, 0);
        return res;
    }
    public int traverse(TreeNode root, int height){
        if (root == null){
            return 0;
        }
        int leftH = traverse(root.left, height+1);
        int rightH = traverse(root.right, height+1);
        res = Math.max(res, leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }
}