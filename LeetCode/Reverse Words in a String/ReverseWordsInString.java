/*
 * Question : 151. Reverse Words in a String
 * Link : https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : Split then remove empty & reverse then join on space
 * Command : `java -ea ReverseWordsInString.java`
 */

public class ReverseWordsInString {

    public static void main(String[] args) {
        ReverseWordsInString solution = new ReverseWordsInString();
        String res = solution.reverseWords("  hello world  ");

        assert res.equals("world hello")
                : "The output is not  'world hello' for '  hello world  ' but '" + res.toString() + "'";
    }

    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");

        int first = 0, last = words.length - 1;

        while (first < last) {
            String temp = words[last];
            words[last--] = words[first].trim();
            words[first++] = temp.trim();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; ++i) {
            if (!words[i].equals("")) {
                if (i != 0)
                    sb.append(" ");
                sb.append(words[i]);
            }
        }

        return sb.toString();
    }
}
