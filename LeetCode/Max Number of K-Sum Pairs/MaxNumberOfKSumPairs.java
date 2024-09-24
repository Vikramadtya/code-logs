/*
 * Question : 1679. Max Number of K-Sum Pairs
 * Link : https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : Use a hashmap to track the occurence of the elemets
 * Command : `java -ea MaxNumberOfKSumPairs.java`
 */

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {

    public static void main(String[] args) {
        MaxNumberOfKSumPairs solution = new MaxNumberOfKSumPairs();
        int res = solution.maxOperations(new int[] { 3, 1, 3, 4, 3 }, 6);

        assert res == 1
                : "The output is not  'true' for '[3,1,3,4,3]' & '6' but '" + res + "'";
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        int operation = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (!m.containsKey(nums[i])) {
                m.put(nums[i], 0);
            }
            m.put(nums[i], m.get(nums[i]) + 1);

            if (m.containsKey(k - nums[i]) && m.containsKey(nums[i])) {

                int temp = m.get(k - nums[i]);

                if ((nums[i] == k - nums[i]) && temp < 2) {
                    continue;
                } else if ((nums[i] == k - nums[i]) && temp >= 2) {
                    operation++;

                    temp -= 2;
                    if (temp > 0) {
                        m.put(k - nums[i], temp);
                    } else {
                        m.remove(k - nums[i]);
                    }

                } else {
                    operation++;

                    temp--;
                    if (temp > 0) {
                        m.put(k - nums[i], temp);
                    } else {
                        m.remove(k - nums[i]);
                    }

                    temp = m.get(nums[i]);
                    temp--;
                    if (temp > 0) {
                        m.put(nums[i], temp);
                    } else {
                        m.remove(nums[i]);
                    }
                }

            }

        }

        return operation;
    }
}
