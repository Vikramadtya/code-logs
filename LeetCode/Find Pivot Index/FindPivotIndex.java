/*
 * Question : 724. Find Pivot Index
 * Link : https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : Calculate the total sum and maintain sum of element seen till now 
 * Command : `java -ea FindPivotIndex.java`
 */

public class FindPivotIndex {
    public static void main(String[] args) {
        FindPivotIndex solution = new FindPivotIndex();
        int res = solution.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 });

        assert res == 3
                : "The output is not  '3' for '[1,7,3,6,5,6]' but '" + res + "'";
    }

    public int pivotIndex(int[] nums) {
        int arrSum = 0;
        for (int i = 0; i < nums.length; ++i)
            arrSum += nums[i];

        int currSum = 0;
        for (int i = 0; i < nums.length; ++i) {

            if ((currSum << 1) == arrSum - nums[i])
                return i;

            currSum += nums[i];

        }

        return -1;
    }
}
