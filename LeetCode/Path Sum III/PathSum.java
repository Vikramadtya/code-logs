/*
 * Question : 437. Path Sum III
 * Link : https://leetcode.com/problems/path-sum-iii/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use prefix sum algorithm do remeber to remove the entry for thee node before returning to avoid garbage
 */

import java.util.HashMap;
import java.util.Map;

public class PathSum {

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

    int count = 0;

    Map<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        countWherePathSumIsTarget(root, targetSum, 0L);
        return count;
    }

    public void countWherePathSumIsTarget(TreeNode root, int targetSum, Long currSum) {

        if (root == null)
            return;
        currSum += root.val;

        if (currSum == targetSum)
            count++;

        count += map.getOrDefault(currSum - targetSum, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        countWherePathSumIsTarget(root.left, targetSum, currSum);
        countWherePathSumIsTarget(root.right, targetSum, currSum);
        map.put(currSum, map.get(currSum) - 1);

    }
}
