/*
 * Question : 547. Number of Provinces
 * Link : https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : two cities x and y belong to the same province if there is a path from city x to city y using the cities that are directly connected. This leads us to consider the problem in terms of graphs.
 * Command : `java -ea KeysAndRooms.java`
 */

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NumberOfProvinces {
    public static void main(String[] args) {
        NumberOfProvinces solution = new NumberOfProvinces();
        int[][] input = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        int res = solution.findCircleNum(input);

        assert res == 2
                : "The output is not '2' for '[[1,1,0],[1,1,0],[0,0,1]]' but '" + res + "'";
    }

    public int findCircleNum(int[][] isConnected) {
        Set<Integer> seen = new HashSet<>();
        Stack<Integer> stack = new Stack<Integer>();

        int count = 0;
        for (int m = 0; m < isConnected.length; ++m) {
            if (!seen.contains(m)) {
                stack.push(m);
                while (!stack.isEmpty()) {
                    int i = stack.pop();
                    if (!seen.contains(i)) {
                        for (int j = 0; j < isConnected[i].length; ++j) {
                            if (isConnected[i][j] == 1)
                                stack.push(j);
                        }

                        seen.add(i);
                    }
                }
                count++;

            }

        }

        return count;
    }
}
