/*
 * Question : 649. Dota2 Senate
 * Link : https://leetcode.com/problems/dota2-senate/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use queue one will always remove the opposition
 * Command : `java -ea Dota2Senate.java`
 */

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public static void main(String[] args) {

        Dota2Senate solution = new Dota2Senate();
        String res = solution.predictPartyVictory("RD");

        assert res.equals("Radiant")
                : "The output is not 'Radiant' for 'RD' but '" + res + "'";

    }

    public String predictPartyVictory(String senate) {
        int r = 0, d = 0;
        Queue<Character> qu = new LinkedList<>();

        for (int i = 0; i < senate.length(); ++i) {
            if (senate.charAt(i) == 'R') {
                r++;
            } else {
                d++;
            }

            qu.add(senate.charAt(i));
        }

        int rToSkip = 0, dToSkip = 0;
        while (r != 0 && d != 0) {
            char temp = qu.remove();

            if (temp == 'R') {
                if (rToSkip > 0) {
                    rToSkip--;
                } else {
                    qu.add(temp);
                    dToSkip++;
                    d--;
                }
            } else {
                if (dToSkip > 0) {
                    dToSkip--;
                } else {
                    qu.add(temp);
                    rToSkip++;
                    r--;
                }
            }
        }

        return (r == 0) ? "Dire" : "Radiant";
    }
}
