/*
 * Question : 11. Container With Most Water
 * Link : https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use two pointer one from end and one from beginning and move inside
 * Command : `java -ea ContainerWithMostWater.java`
 */

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int res = solution.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 });

        assert res == 49
                : "The output is not '49' for '[1, 8, 6, 2, 5, 4, 8, 3, 7]' but '" + res + "'";
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, max = 0;

        while (i < j) {
            if (Math.min(height[i], height[j]) * (j - i) > max) {
                max = Math.min(height[i], height[j]) * (j - i);
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
