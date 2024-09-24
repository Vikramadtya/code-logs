/*
 * Question : 394. Decode String
 * Link : https://leetcode.com/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use multiple stacks to resolve some string can be inside multiple []
 * Command : `java -ea DecodeString.java`
 */

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

        DecodeString solution = new DecodeString();
        String res = solution.decodeString("2[abc]3[cd]ef");

        assert res.equals("abcabccdcdcdef")
                : "The output is not '2[abc]3[cd]ef' for 'abcabccdcdcdef' but '" + res + "'";

    }

    public String decodeString(String s) {
        Stack<Character> mstack = new Stack<>();
        Stack<String> bstack = new Stack<>();

        for (char x : s.toCharArray())
            mstack.push(x);

        StringBuilder fsb = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        while (!mstack.isEmpty()) {
            char temp = mstack.pop();
            if (temp == ']') {
                bstack.push(sb.toString());
                sb = new StringBuilder();
            } else if (temp == '[') {
                String suffix = bstack.pop();
                int times = 1, digit = 0;
                while (!mstack.isEmpty() && mstack.peek() <= '9' && mstack.peek() >= '0') {
                    digit += (mstack.pop() - '0') * times;
                    times *= 10;
                }

                if (bstack.isEmpty()) {

                    fsb.append(sb.toString().repeat(digit));

                } else {
                    for (var x : sb.reverse().toString().repeat(digit).toCharArray())
                        mstack.push(x);
                    for (var x : new StringBuilder(suffix).reverse().toString().toCharArray())
                        mstack.push(x);

                }

                sb = new StringBuilder();

            } else if (!bstack.isEmpty()) {
                sb.append(temp);
            } else {
                fsb.append(temp);
            }
        }

        return fsb.reverse().toString();

    }
}
