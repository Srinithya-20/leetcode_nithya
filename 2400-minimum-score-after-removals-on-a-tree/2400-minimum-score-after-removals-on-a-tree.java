class Solution {
    private List<Integer>[] tree;
    private int[] xor;
    private int totalXor;
    private int[] in, out;
    private int time = 0;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        xor = new int[n];
        boolean[] visited = new boolean[n];
        dfs(0, -1, nums, visited);  // Fill xor values
        totalXor = xor[0];

        in = new int[n];
        out = new int[n];
        dfsTime(0, -1);  // Fill in and out times for ancestor checks

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < edges.length; i++) {
            for (int j = i + 1; j < edges.length; j++) {
                int[] edge1 = edges[i];
                int[] edge2 = edges[j];

                int u1 = getChild(edge1[0], edge1[1]);
                int u2 = getChild(edge2[0], edge2[1]);

                if (isAncestor(u1, u2)) {
                    int x = xor[u2];
                    int y = xor[u1] ^ xor[u2];
                    int z = totalXor ^ xor[u1];
                    res = Math.min(res, getScore(x, y, z));
                } else if (isAncestor(u2, u1)) {
                    int x = xor[u1];
                    int y = xor[u2] ^ xor[u1];
                    int z = totalXor ^ xor[u2];
                    res = Math.min(res, getScore(x, y, z));
                } else {
                    int x = xor[u1];
                    int y = xor[u2];
                    int z = totalXor ^ xor[u1] ^ xor[u2];
                    res = Math.min(res, getScore(x, y, z));
                }
            }
        }

        return res;
    }

    private int dfs(int node, int parent, int[] nums, boolean[] visited) {
        visited[node] = true;
        xor[node] = nums[node];
        for (int nei : tree[node]) {
            if (nei == parent) continue;
            xor[node] ^= dfs(nei, node, nums, visited);
        }
        return xor[node];
    }

    private void dfsTime(int node, int parent) {
        in[node] = ++time;
        for (int nei : tree[node]) {
            if (nei == parent) continue;
            dfsTime(nei, node);
        }
        out[node] = ++time;
    }

    private boolean isAncestor(int u, int v) {
        return in[u] <= in[v] && out[u] >= out[v];
    }

    private int getChild(int u, int v) {
        return isAncestor(u, v) ? v : u;
    }

    private int getScore(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return max - min;
    }
}