/*
 * Question : 560. Subarray Sum Equals K
 * Link : https://leetcode.com/problems/subarray-sum-equals-k/description/
 * Summary : use prefix sum algorithm straight forward
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int res = solution.subarraySum(new int[] { 1, 1, 1 }, 2);

        assert res == 2
                : "The output is not '[10]' for '[1,1,1]' & '2' but '" + res + "'";
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int currSum = 0, count = 0;
        for (int i = 0; i < nums.length; ++i) {
            currSum += nums[i];

            if (currSum == k)
                count++;

            count += m.getOrDefault(currSum - k, 0);

            m.put(currSum, m.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}
