/*
 * Question : 735. Asteroid Collision
 * Link : https://leetcode.com/problems/asteroid-collision/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : use stack inisde a loop and remove accordingly
 * Command : `java -ea AsteroidCollision.java`
 */

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        AsteroidCollision solution = new AsteroidCollision();
        int[] res = solution.asteroidCollision(new int[] { 10, 2, -5 });

        assert Arrays.toString(res).equals("[10]")
                : "The output is not '[10]' for '[10,2,-5]' but '" + Arrays.toString(res) + "'";
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; ++i) {
            while (true) {
                if (!stack.isEmpty() && ((stack.peek() > 0 && asteroids[i] < 0))) {
                    if (Math.abs(stack.peek()) > Math.abs(asteroids[i])) {
                        break;
                    } else if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                        stack.pop();
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(asteroids[i]);
                    break;
                }
            }
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            res[i] = stack.pop();
        }
        return res;
    }
}
