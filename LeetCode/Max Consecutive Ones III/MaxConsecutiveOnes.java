/*
 * Question : 1004. Max Consecutive Ones III
 * Link : https://leetcode.com/problems/max-consecutive-ones-iii/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : We keep expanding the window by moving the right pointer. When the window has reached the limit of 0's allowed, we contract (if possible) and save the longest window till now.
 * Command : `java -ea MaxConsecutiveOnes.java`
 */

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        MaxConsecutiveOnes solution = new MaxConsecutiveOnes();
        int res = solution.longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2);

        assert res == 6
                : "The output is not  '6' for '[1,1,1,0,0,0,1,1,1,1,0]' & '2' but '" + res + "'";
    }

    public int longestOnes(int[] nums, int k) {
        int first = 0, last = -1;
        int temp = k;
        while (last + 1 < nums.length) {
            if (nums[last + 1] == 0) {
                if (temp <= 0)
                    break;
                temp--;
            }
            last++;
        }

        int maxLen = last - first + 1;

        for (; first < nums.length && last + 1 < nums.length;) {
            if (nums[first] == 0) {
                temp = 1;
                while (last + 1 < nums.length) {
                    if (nums[last + 1] == 0 && temp > 0) {
                        last++;
                        temp--;
                    } else if (nums[last + 1] == 1) {
                        last++;
                    } else {
                        break;
                    }
                }

                if (last - first > maxLen)
                    maxLen = last - first;
            }

            first++;
        }

        return maxLen;
    }
}
