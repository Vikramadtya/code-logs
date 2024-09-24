/*
 * Question : 700. Search in a Binary Search Tree
 * Link : https://leetcode.com/problems/search-in-a-binary-search-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : simple BST traversal
 */

public class SearchInBinarySearchTree {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;
        if (root.val < val)
            return searchBST(root.right, val);
        if (root.val > val)
            return searchBST(root.left, val);
        return null;
    }
}
