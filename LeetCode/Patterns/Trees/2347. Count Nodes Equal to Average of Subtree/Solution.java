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
    int c=0;
    public int averageOfSubtree(TreeNode root) {
        pO(root);
        return c;
    }
    private int[] pO(TreeNode node){
        if(node==null) return new int[] {0,0};
        int[] l=pO(node.left);
        int[] r=pO(node.right);
        int s=l[0]+r[0]+node.val;
        int c1=l[1]+r[1]+1;
        if(s/c1==node.val) c++;
        return new int[]{s,c1};
    }
}