/*
 * Question : 2215. Find the Difference of Two Arrays
 * Link : https://leetcode.com/problems/find-the-difference-of-two-arrays/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : can be solved using map and set
 * Command : `java -ea FindDifferenceOfTwoArrays.java`
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindDifferenceOfTwoArrays {
    public static void main(String[] args) {
        FindDifferenceOfTwoArrays solution = new FindDifferenceOfTwoArrays();
        List<List<Integer>> res = solution.findDifference(new int[] { 1, 2, 3, 3 }, new int[] { 1, 1, 2, 2 });

        assert res.toString().equals("[[3], []]")
                : "The output is not '[[3], []]' for '[1, 2, 3, 3]' & '[1, 1, 2, 2]' but '" + res + "'";
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Map<Integer, Boolean> m = new HashMap<>();

        for (int i = 0; i < nums1.length; ++i) {
            m.put(nums1[i], true);
        }

        Set<Integer> num2 = new HashSet<>();
        for (int i = 0; i < nums2.length; ++i) {
            if (!m.containsKey(nums2[i])) {
                num2.add(nums2[i]);
            } else {
                m.put(nums2[i], false);
            }
        }

        List<Integer> num1 = new ArrayList<>();

        for (Integer x : m.keySet()) {
            if (m.get(x)) {
                num1.add(x);
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        res.add(num1);
        res.add(new ArrayList<>(num2));

        return res;

    }
}
