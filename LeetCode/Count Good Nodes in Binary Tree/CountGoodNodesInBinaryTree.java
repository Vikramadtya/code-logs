/*
 * Question : 1448. Count Good Nodes in Binary Tree
 * Link : https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use recurssion and pass the max seen so far
 */

public class CountGoodNodesInBinaryTree {
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

    public int goodNodes(TreeNode root) {
        int count = countGoodNodes(root, Integer.MIN_VALUE);
        return count;
    }

    int countGoodNodes(TreeNode root, int maxValue) {
        if (root == null)
            return 0;

        int value = maxValue;
        if (root.val > maxValue) {
            value = root.val;
        }

        return countGoodNodes(root.left, value) + countGoodNodes(root.right, value) + ((root.val >= maxValue) ? 1 : 0);
    }
}
