/*
 * Question : 2352. Equal Row and Column Pairs
 * Link : https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 * Summary : create hash of the rows and check if column is there
 */

import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> cvalues = new HashMap<>();
        Map<String, Integer> rvalues = new HashMap<>();
        int count = 0;

        for (int i = 0; i < grid.length; ++i) {
            StringBuilder row = new StringBuilder();
            StringBuilder column = new StringBuilder();

            for (int j = 0; j < grid.length; ++j) {
                row.append("," + grid[i][j]);
                column.append("," + grid[j][i]);
            }

            if (cvalues.containsKey(row.toString())) {
                count += cvalues.get(row.toString());
            }

            rvalues.put(row.toString(), rvalues.getOrDefault(row.toString(), 0) + 1);

            if (rvalues.containsKey(column.toString())) {
                count += rvalues.get(column.toString());
            }

            cvalues.put(column.toString(), cvalues.getOrDefault(column.toString(), 0) + 1);

        }

        return count;
    }
}
