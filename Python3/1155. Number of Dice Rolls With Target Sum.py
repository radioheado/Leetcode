class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        
        MOD = 10**9 + 7
        dp = [[None] * (target + 1) for _ in range(n + 1)]
        
        def helper(dice, sumi):
            # reach to the final dice
            if dice == n:
                return 1 if sumi == target else 0
            
            if dp[dice][sumi] != None:
                return dp[dice][sumi]
            
            ways = 0
            for i in range(1, min(k, target - sumi) + 1):
                ways = (ways + helper(dice + 1, sumi + i)) % MOD
                
            dp[dice][sumi] = ways
            return ways
        
        return helper(0, 0)