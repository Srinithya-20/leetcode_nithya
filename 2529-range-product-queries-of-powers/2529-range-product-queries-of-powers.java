class Solution {
    static final int MOD = 1_000_000_007;
    
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            if ((n & (1 << i)) != 0) powers.add(1 << i);
        }
        int m = powers.size();
        long[] prefix = new long[m];
        prefix[0] = powers.get(0) % MOD;
        for (int i = 1; i < m; i++) {
            prefix[i] = (prefix[i - 1] * powers.get(i)) % MOD;
        }
        int[] ans = new int[queries.length];
        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];
            long product = prefix[r];
            if (l > 0) {
                product = (product * modPow(prefix[l - 1], MOD - 2)) % MOD;
            }
            ans[qi] = (int) product;
        }
        return ans;
    }
    
    private long modPow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}