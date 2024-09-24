/*
 * Question : 334. Increasing Triplet Subsequence
 * Link : https://leetcode.com/problems/increasing-triplet-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : we only need to indentify if a sequence exists not the exact indexes
 * Command : `java -ea IncreasingTripletSubsequence.java`
 */

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {

        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();
        boolean res = solution.increasingTriplet(new int[] { 1, 2, 0, 3 });

        assert res == true
                : "The output is not  'true' for '[1,2,0,3]' but '" + res + "'";

    }

    /*
     * [1,2,0,3] # should return True as the increasing triplet subsequence is 1, 2,
     * and 3
     * Even though smallest is updated in Line 3, ssmallest is never updated again.
     * However, you can tell that there exists another number before ssmallest which
     * is definitely BIGGER
     * than the last updated smallest but SMALLER than ssmallest.
     * This is a very important observation.
     * Therefore, can safely say that there exists an increasing triplet
     * subsequence as soon as you see a number which is bigger than the last updated
     * smallest and ssmallest
     * even though that last updated smallest is not one of the actual numbers of
     * the increasing triplet subsequence.
     */
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int ssmallest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= smallest) {
                smallest = nums[i];
            } else if (nums[i] <= ssmallest) {
                ssmallest = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }
}
