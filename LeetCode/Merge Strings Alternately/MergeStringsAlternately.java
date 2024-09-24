/*
 * Question : 1768. Merge Strings Alternately
 * Link : https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
 * Command : `java -ea MergeStringsAlternately.java`
 */
class MergeStringsAlternately {

    public static void main(String[] args) {
        MergeStringsAlternately solution = new MergeStringsAlternately();
        String res = solution.mergeAlternately("ab", "pqrs");

        assert (res.equals("apbqrs")) : "The output is not 'apbqcr' for 'ab' & 'pqrs'";
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;

        for (; i < word1.length() && j < word2.length();) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        if (i < word1.length())
            sb.append(word1.substring(i, word1.length()));

        if (j < word2.length())
            sb.append(word2.substring(j, word2.length()));

        return sb.toString();
    }
}