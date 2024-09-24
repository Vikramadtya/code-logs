/*
 * Question : 104. Maximum Depth of Binary Tree
 * Link : https://leetcode.com/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use recurssion and pass the current depth
 */

public class MaximumDepthOfBinaryTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        return maxDepthFinder(root, 0);
    }

    public int maxDepthFinder(TreeNode root, int depth) {

        if (root == null)
            return depth;

        int left = maxDepthFinder(root.left, depth + 1);
        int right = maxDepthFinder(root.right, depth + 1);

        return (left > right) ? left : right;

    }

}
