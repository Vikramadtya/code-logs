/*
 * Question : 392. Is Subsequence
 * Link : https://leetcode.com/problems/is-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : iterate over string and increase subsequence index till end if unable to reach end then is not subsequence
 * Command : `java -ea IsSubsequence.java`
 */

public class IsSubsequence {

    public static void main(String[] args) {

        IsSubsequence solution = new IsSubsequence();
        boolean isSubsequence = solution.isSubsequence("abc", "ahbgdc");

        assert isSubsequence == true
                : "The output is not  'true' for 'abc' & 'ahbgdc' but '" + Boolean.toString(isSubsequence) + "'";

    }

    public boolean isSubsequence(String s, String t) {
        int j = 0;

        if (s.length() < 1)
            return true;

        for (int i = 0; i < t.length(); ++i) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
                if (j == s.length())
                    return true;
            }

        }

        return false;
    }

}
