/*
 * Question : 841. Keys and Rooms
 * Link : https://leetcode.com/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : can be solved using DFS by considering keys as the nodes
 * Command : `java -ea KeysAndRooms.java`
 */

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    public static void main(String[] args) {
        KeysAndRooms solution = new KeysAndRooms();
        List<List<Integer>> input = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2),
                Arrays.asList(0));

        boolean res = solution.canVisitAllRooms(input);

        assert res != true
                : "The output is not 'false' for '[[1,3],[3,0,1],[2],[0]]' but '" + res + "'";
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        boolean[] seen = new boolean[rooms.size()];
        stack.push(0);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            if (!seen[i]) {
                for (int j = 0; j < rooms.get(i).size(); ++j) {
                    stack.push(rooms.get(i).get(j));
                }
                seen[i] = true;
                ;
            }
        }
        for (boolean x : seen)
            if (!x)
                return false;
        return true;
    }
}