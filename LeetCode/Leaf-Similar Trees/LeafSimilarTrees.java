/*
 * Question : 872. Leaf-Similar Trees
 * Link : https://leetcode.com/problems/leaf-similar-trees/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use DFS to create the list of leaf nodes and compare
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeafSimilarTrees {

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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> tree1 = new Stack<>();
        List<Integer> leafs1 = new ArrayList<>();

        tree1.add(root1);
        while (!tree1.isEmpty()) {
            TreeNode temp = tree1.pop();

            if (temp.left == null && temp.right == null) {
                leafs1.add(temp.val);
            } else {
                if (temp.left != null)
                    tree1.push(temp.left);
                if (temp.right != null)
                    tree1.push(temp.right);
            }
        }

        Stack<TreeNode> tree2 = new Stack<>();
        int count = 0;
        tree2.add(root2);
        while (!tree2.isEmpty()) {
            TreeNode temp = tree2.pop();

            if (temp.left == null && temp.right == null) {
                if (count >= leafs1.size() || leafs1.get(count++) != temp.val)
                    return false;
            } else {
                if (temp.left != null)
                    tree2.push(temp.left);
                if (temp.right != null)
                    tree2.push(temp.right);
            }
        }

        if (count != leafs1.size())
            return false;
        return true;
    }
}
