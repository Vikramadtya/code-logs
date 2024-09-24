/*
 * Question : 443. String Compression
 * Link : https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : just count the occurence and the previous seen character if it doesn't match current dump into array and current becomes previous with occurence 1
 * Command : `java -ea StringCompression.java`
 */

public class StringCompression {

    public static void main(String[] args) {

        StringCompression solution = new StringCompression();
        int length = solution.compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' });

        assert length == 6
                : "The output is not  6 for ['a','a','b','b','c','c','c'] but '" + Integer.toString(length) + "'";

    }

    public int compress(char[] chars) {
        int k = 0;

        char prev = chars[0];
        int consecutivecount = 1;
        for (int i = 1; i <= chars.length; ++i) {
            if (i < chars.length && chars[i] == prev) {
                consecutivecount++;
            } else {
                chars[k++] = prev;
                if (consecutivecount > 1) {
                    String temp = Integer.toString(consecutivecount);

                    for (int j = 0; j < temp.length(); ++j) {
                        chars[k++] = temp.charAt(j);
                    }

                }

                consecutivecount = 1;
                if (i < chars.length)
                    prev = chars[i];
            }
        }

        return k;
    }
}
