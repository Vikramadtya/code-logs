/*
 * Question : 1732. Find the Highest Altitude
 * Link : https://leetcode.com/problems/find-the-highest-altitude/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : Iterate over the array and add to find the altitude 
 * Command : `java -ea FindHighestAltitude.java`
 */

public class FindHighestAltitude {

    public static void main(String[] args) {
        FindHighestAltitude solution = new FindHighestAltitude();
        int res = solution.largestAltitude(new int[] { -5, 1, 5, 0, -7 });

        assert res == 1
                : "The output is not  '1' for '[-5,1,5,0,-7]'  but '" + res + "'";
    }

    public int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;
        for (int i = 0; i < gain.length; ++i) {
            curr += gain[i];
            if (curr > max)
                max = curr;
        }

        return max;
    }
}
