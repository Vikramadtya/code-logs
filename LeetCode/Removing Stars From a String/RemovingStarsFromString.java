/*
 * Question : 2390. Removing Stars From a String
 * Link : https://leetcode.com/problems/removing-stars-from-a-string/description/
 * Summary : keep in stack pop if seen a star
 * Command : `java -ea RemovingStarsFromString.java`
 */

import java.util.Stack;

public class RemovingStarsFromString {

    public static void main(String[] args) {

        RemovingStarsFromString solution = new RemovingStarsFromString();
        String res = solution.removeStars("leet**cod*e");

        assert res.equals("lecoe")
                : "The output is not  'lecoe' for 'leet**cod*e' but '" + res + "'";

    }

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '*') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
