
/*
 * Question : 1071. Greatest Common Divisor of Strings
 * Link : https://leetcode.com/problems/greatest-common-divisor-of-strings/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : we only need to indentify if a sequence exists not the exact indexes
 * Command : `java -ea GreatestCommonDivisorStrings.java`
 */

public class GreatestCommonDivisorStrings {
    public static void main(String[] args) {

        GreatestCommonDivisorStrings solution = new GreatestCommonDivisorStrings();
        String res = solution.gcdOfStrings("ABAB", "ABABABAB");

        assert res.equals("ABAB")
                : "The output is not  'ABAB' for 'ABAB' & 'ABABABAB' but '" + res + "'";

    }

    /*
     * If we start the loop from beginning then we get the LCM
     */
    public String gcdOfStrings(String str1, String str2) {
        int divisorLen = Math.min(str1.length(), str2.length());
        String divisor = str1.length() < str2.length() ? str1 : str2;

        for (int i = divisorLen; i > 0; --i) {
            if (str1.length() % i == 0 && str2.length() % i == 0) {
                String temp = divisor.substring(0, i);
                if (temp.repeat(str1.length() / i).equals(str1) && temp.repeat(str2.length() / i).equals(str2)) {
                    return temp;
                }
            }
        }

        return "";
    }
}
