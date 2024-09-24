/*
 * Question : 1161. Maximum Level Sum of a Binary Tree
 * Link : https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use breadth first search alogn with maintaining the current and next level
 */

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfBinaryTree {
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

    public int maxLevelSum(TreeNode root) {
        return bfs(root);
    }

    public int bfs(TreeNode root) {
        int current = 1, next = 2, maxLevel = -1, max = Integer.MIN_VALUE;

        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
            int sum = 0;
            if (!currentLevel.isEmpty()) {
                // System.out.print("Current : ");
                while (!currentLevel.isEmpty()) {
                    TreeNode temp = currentLevel.remove();
                    sum += temp.val;
                    // System.out.print(temp.val + " ");
                    if (temp.left != null)
                        nextLevel.add(temp.left);
                    if (temp.right != null)
                        nextLevel.add(temp.right);
                }
                // System.out.println(" = "+ sum);

                if (sum > max) {
                    maxLevel = current;
                    max = sum;
                }
                current += 2;
            }

            sum = 0;
            if (!nextLevel.isEmpty()) {
                // System.out.print("Next : ");
                while (!nextLevel.isEmpty()) {
                    TreeNode temp = nextLevel.remove();
                    sum += temp.val;
                    // System.out.print(temp.val + " ");
                    if (temp.left != null)
                        currentLevel.add(temp.left);
                    if (temp.right != null)
                        currentLevel.add(temp.right);
                }

                // System.out.println(" = "+ sum);

                if (sum > max) {
                    maxLevel = next;
                    max = sum;
                }
                next += 2;
            }

        }

        return maxLevel;
    }

}
