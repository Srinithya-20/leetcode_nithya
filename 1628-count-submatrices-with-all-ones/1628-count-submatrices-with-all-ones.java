class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] heights = new int[n];
        int result = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            result += countRectangles(heights);
        }
        return result;
    }
    
    private int countRectangles(int[] heights) {
        int n = heights.length;
        int res = 0;
        int[] sum = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int j = 0; j < n; j++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[j]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                int prev = stack.peek();
                sum[j] = sum[prev] + heights[j] * (j - prev);
            } else {
                sum[j] = heights[j] * (j + 1);
            }
            stack.push(j);
            res += sum[j];
        }
        return res;
    }
}