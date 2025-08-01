import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // First and last elements are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of two values from the row above
                    int sum = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(sum);
                }
            }
            triangle.add(row);
        }

        return triangle;
    }
}