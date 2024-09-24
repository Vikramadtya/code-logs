/*
 * Question : 1207. Unique Number of Occurrences
 * Link : https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use a map & set
 * Command : `java -ea UniqueNumberOfOccurrences.java`
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        UniqueNumberOfOccurrences solution = new UniqueNumberOfOccurrences();
        boolean res = solution.uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 });

        assert res == true
                : "The output is not 'true' for '[1,2,2,1,1,3]' but '" + res + "'";
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < arr.length; ++i) {
            m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> s = new HashSet<>();

        for (Integer x : m.values()) {
            if (s.contains(x))
                return false;
            s.add(x);
        }

        return true;
    }

}
