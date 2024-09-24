/*
 * Question : 1431. Kids With the Greatest Number of Candies
 * Link : https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : Iterate to find the greatest then again iterate and check if for some element after adding candies value is greater or equal to max
 * word is finished add all as it is
 * Command : `java -ea KidsWithTheGreatestNumberOfCandies.java`
 * Time Complexity : O(n) where n is the number of candies
 * Space Complexity : O(n) where n is the number of candies
 */

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {

    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies solution = new KidsWithTheGreatestNumberOfCandies();
        List<Boolean> res = solution.kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3);

        assert res.toString().equals("[true, true, true, false, true]")
                : "The output is not  '[true,true,true,false,true]' for '[2,3,5,1,3]' & '3' but " + res.toString();
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; ++i) {
            if (candies[i] > max)
                max = candies[i];
        }

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; ++i) {
            res.add((candies[i] + extraCandies) >= max);
        }

        return res;
    }

}
