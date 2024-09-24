/*
 * Question : 283. Move Zeroes
 * Link : https://leetcode.com/problems/move-zeroes/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : iterate over array and keep track of last non zero position and add digit after that for all remaining in the end put 0
 * Command : `java -ea MoveZeroes.java`
 */

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] res = new int[] { 0, 1, 0, 3, 12 };

        MoveZeroes solution = new MoveZeroes();
        solution.moveZeroes(res);

        assert Arrays.toString(res).equals("[1, 3, 12, 0, 0]")
                : "The output is not  '[1,3,12,0,0]' for '[0, 1, 0, 3, 12]' but '" + Arrays.toString(res) + "'";

    }

    public void moveZeroes(int[] nums) {
        int lastNonZeroIndex = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[++lastNonZeroIndex] = nums[i];
            }
        }

        for (int i = ++lastNonZeroIndex; i < nums.length; ++i) {
            nums[i] = 0;
        }

    }
}
