/*
 * Question : 450. Delete Node in a BST
 * Link : https://leetcode.com/problems/delete-node-in-a-bst/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : find the inorder successor and make the left of that point to the left of the target node
 */

public class DeleteNodeInBST {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
        dummy.right = root;

        deleteNode(root, dummy, key);

        return dummy.right;
    }

    public void deleteNode(TreeNode root, TreeNode prev, int key) {
        if (root == null)
            return;
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                if (root.val > prev.val) {
                    prev.right = null;
                } else {
                    prev.left = null;
                }
            } else if (root.left != null && root.right != null) {
                TreeNode inorderSuccessor = root.right;

                while (inorderSuccessor.left != null) {
                    inorderSuccessor = inorderSuccessor.left;
                }

                inorderSuccessor.left = root.left;

                if (root.val > prev.val) {
                    prev.right = root.right;
                } else {
                    prev.left = root.right;
                }
            } else if (root.left != null) {
                if (root.val > prev.val) {
                    prev.right = root.left;
                } else {
                    prev.left = root.left;
                }
            } else {
                if (root.val > prev.val) {
                    prev.right = root.right;
                } else {
                    prev.left = root.right;
                }
            }
        } else if (key > root.val) {
            deleteNode(root.right, root, key);
        } else {
            deleteNode(root.left, root, key);
        }

    }
}
