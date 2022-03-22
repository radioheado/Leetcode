class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # special case
        if not amount:
            return 0
        
        dp = [inf] * (amount + 1)
        coins = set(coins)
        
        for i in range(1, amount+1):
            # if i is one of the coins, we only need one to make up this amount
            if i in coins:
                #print(i)
                dp[i] = 1
                continue
                
            for n in coins:
                # if we know how to make up i-n, then add one coin of n 
                # we'll get i
                if i-n >0 and dp[i-n] != inf:
                    dp[i] = min(dp[i], dp[i-n]+1)
        #print(dp)            
        return dp[-1] if dp[-1] != inf else -1
                    
        