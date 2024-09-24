/*
 * Question : 933. Number of Recent Calls
 * Link : https://leetcode.com/problems/number-of-recent-calls/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : simple use of queue
 */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    Queue<Integer> qu = new LinkedList<>();

    public void RecentCounter() {
        qu = new LinkedList<>();
    }

    public int ping(int t) {
        while (!qu.isEmpty() && (t - qu.peek() > 3000)) {
            qu.remove();
        }

        qu.add(t);

        return qu.size();
    }
}
