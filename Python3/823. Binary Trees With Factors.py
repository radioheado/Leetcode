class Solution:
    def numFactoredBinaryTrees(self, arr: List[int]) -> int:
        MOD = 10**9 + 7
        dp = [1] * len(arr)
        arr.sort()
        index = {x: i for i, x in enumerate(arr)}
        
        for i, x in enumerate(arr):
            for j in range(i):
                # arr[j] is x's left child
                if x % arr[j] == 0:
                    right = x // arr[j]
                    
                    # found the corresponding right chil
                    if right in index:
                        dp[i] += dp[j] * dp[index[right]]
                        dp[i] %= MOD
                        
        return sum(dp) % MOD
        