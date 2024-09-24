/*
 * Question : 238. Product of Array Except Self
 * Link : https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : O(n) space, use two array one for suffix and one for prefix
 * Command : `java -ea ProductOfArrayExceptSelf.java`
 */

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] res = solution.productExceptSelf(new int[] { 1, 2, 3, 4 });

        assert Arrays.toString(res).equals("[24, 12, 8, 6]")
                : "The output is not  '[24,12,8,6]' for '[1, 2, 3, 4]' but '" + Arrays.toString(res) + "'";
    }

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                prefix[i] = 1;
            } else {
                prefix[i] = prefix[i - 1] * nums[i - 1];
            }
        }

        for (int j = nums.length - 1; j >= 0; --j) {
            if (j == nums.length - 1) {
                suffix[j] = 1;
            } else {
                suffix[j] = suffix[j + 1] * nums[j + 1];
            }
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }
}
