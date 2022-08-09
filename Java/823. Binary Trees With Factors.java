class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int N = arr.length, MOD = 1000000007;
        long[] dp = new long[N];
        Arrays.fill(dp, 1);
        
        Map<Integer, Integer> index = new HashMap();
        for (int i=0; i<N; i++) {
            index.put(arr[i], i);
        }
        
        int right;
        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] % arr[j] == 0) {
                    right = arr[i] / arr[j];
                    if (index.containsKey(right)) {
                        dp[i] += dp[j] * dp[index.get(right)];
                        dp[i] %= MOD;
                    }
                }
            }
        }
        
        long res = 0;
        for (long n: dp) {
            res = (res + n) % MOD;
        }
        
        return (int)res;
    }
}