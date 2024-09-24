/*
 * Question : 345. Reverse Vowels of a String
 * Link : https://leetcode.com/problems/reverse-vowels-of-a-string/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use two pointer two track vowels from both ends and replace them
 * Command : `java -ea ReverseVowelsOfString.java`
 */

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {

    public static void main(String[] args) {

        ReverseVowelsOfString solution = new ReverseVowelsOfString();
        String res = solution.reverseVowels("hello");

        assert res.equals("holle")
                : "The output is not  'holle' for 'hello' but '" + res + "'";

    }

    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = s.length() - 1;

        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        while (i < j) {
            if (vowels.contains(sb.charAt(i)) && vowels.contains(sb.charAt(j))) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);

                i++;
                j--;
            } else if (vowels.contains(sb.charAt(i)) && !vowels.contains(sb.charAt(j))) {
                j--;
            } else if (!vowels.contains(sb.charAt(i)) && vowels.contains(sb.charAt(j))) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        return sb.toString();
    }

}
