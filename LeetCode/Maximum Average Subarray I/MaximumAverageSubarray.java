/*
 * Question : 643. Maximum Average Subarray I
 * Link : https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : Simple sliding window choose the min value cautiously 
 * Command : `java -ea MaximumAverageSubarray.java`
 */

public class MaximumAverageSubarray {
    public static void main(String[] args) {
        MaximumAverageSubarray solution = new MaximumAverageSubarray();
        double res = solution.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4);

        assert res == 12.75000
                : "The output is not  '12.75000' for '[1, 12, -5, -6, 50, 3]' & '4' but '" + res + "'";
    }

    public double findMaxAverage(int[] nums, int k) {

        double max = -Double.MAX_VALUE, sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i - j + 1 <= k) {
                sum += nums[i];
            } else {
                if (sum > max)
                    max = sum;
                sum -= nums[j++];
                sum += nums[i];
            }
        }

        if (sum > max)
            max = sum;

        return max / k;
    }
}
