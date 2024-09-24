/*
 * Question : 1456. Maximum Number of Vowels in a Substring of Given Length
 * Link : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : simply count occurence of vowels in first k character then increase or decrease count based on new addition and deletion as window moves forward
 * Command : `java -ea MaximumNumberOfVowelsInSubstringOfGivenLength.java`
 */

public class MaximumNumberOfVowelsInSubstringOfGivenLength {

    public static void main(String[] args) {

        MaximumNumberOfVowelsInSubstringOfGivenLength solution = new MaximumNumberOfVowelsInSubstringOfGivenLength();
        int length = solution.maxVowels("weallloveyou", 7);

        assert length == 4
                : "The output is not 4 for 'weallloveyou' but '" + Integer.toString(length) + "'";

    }

    public int maxVowels(String s, int k) {

        int count = 0;

        for (int i = 0; i < k; ++i) {
            char addedChar = s.charAt(i);

            if (addedChar == 'a' ||
                    addedChar == 'e' ||
                    addedChar == 'i' ||
                    addedChar == 'o' ||
                    addedChar == 'u') {
                count++;
            }

        }

        int max = count;

        if (k < s.length()) {
            for (int i = k; i < s.length(); ++i) {
                char addedChar = s.charAt(i);
                char removedChar = s.charAt(i - k);

                if (addedChar == 'a' ||
                        addedChar == 'e' ||
                        addedChar == 'i' ||
                        addedChar == 'o' ||
                        addedChar == 'u') {
                    count++;
                }

                if (removedChar == 'a' ||
                        removedChar == 'e' ||
                        removedChar == 'i' ||
                        removedChar == 'o' ||
                        removedChar == 'u') {
                    count--;
                }

                if (count > max)
                    max = count;

            }
        }

        return max;
    }
}
