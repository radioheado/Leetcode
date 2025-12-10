class Solution {
    public int countPermutations(int[] complexity) {
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        int MOD = 1_000_000_007;
        long ans = 1;
        for (int i = 2; i < complexity.length; i++) {
            ans = ((long) ans * i) % MOD;
        }

        return (int) ans;
    }
}