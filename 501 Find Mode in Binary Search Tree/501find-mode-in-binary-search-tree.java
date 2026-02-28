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
    private int currCount = 0, maxCount = 0;
    private TreeNode prev = null;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        modes.clear();
        currCount = 0;
        prev = null;
        maxCount = maxCount;
        inorder(root);
        return modes.stream().mapToInt(i -> i).toArray();
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);
        if (prev != null && node.val == prev.val) {
            currCount++;
        } else {
            currCount = 1;
        }

        if (currCount > maxCount) {
            maxCount = currCount;
            modes.clear();
            modes.add(node.val);
        } else if (currCount == maxCount) {
            modes.add(node.val);
        }

        prev = node;
        inorder(node.right);
    }
}