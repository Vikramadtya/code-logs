/*
 * Question : 1493. Longest Subarray of 1's After Deleting One Element
 * Link : https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : We keep expanding the window by moving the right pointer. When the window has reached the limit, we contract till we remove the 0 and save the longest window till now.
 * Command : `java -ea LongestSubarrayAfterDeletingOneElement.java`
 */

public class LongestSubarrayAfterDeletingOneElement {
    public static void main(String[] args) {
        LongestSubarrayAfterDeletingOneElement solution = new LongestSubarrayAfterDeletingOneElement();
        int res = solution.longestSubarray(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 });

        assert res == 5
                : "The output is not  '5' for '[0, 1, 1, 1, 0, 1, 1, 0, 1]' & '2' but '" + res + "'";
    }

    public int longestSubarray(int[] nums) {
        int j = 0;
        boolean deleted = false;
        int maxLen = 0;
        for (int i = 0; i < nums.length;) {
            if (nums[i] == 0) {
                if (!deleted) {
                    deleted = true;
                    if (i - j > maxLen)
                        maxLen = i - j;

                    i++;
                } else {
                    if (nums[j++] == 0)
                        deleted = false;
                }
            } else {
                if (i - j > maxLen)
                    maxLen = i - j;
                i++;
            }
        }

        return maxLen;
    }
}
