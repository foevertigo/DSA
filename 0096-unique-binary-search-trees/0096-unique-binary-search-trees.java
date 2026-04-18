class Solution {
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        return count(n, memo);
    }

    private int count(int n, int[] memo) {
        if (n <= 1) return 1;

        if (memo[n] != 0) return memo[n];

        int total = 0;

        for (int i = 1; i <= n; i++) {
            int left = count(i - 1, memo);
            int right = count(n - i, memo);
            total += left * right;
        }

        memo[n] = total;
        return total;
    }
}