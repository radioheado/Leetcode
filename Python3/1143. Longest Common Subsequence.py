class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        i = j = 0
        m, n = len(text1), len(text2)
        
        # if text1[i] == text2[j]:
        #   dp[i][j] = dp[i-1][j-1] + 1 
        # else:
        #   dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        
        dp = [[0]*(n+1) for _ in range(m+1)]
        
        for j in reversed(range(n)):
            for i in reversed(range(m)):
                if text2[j] == text1[i]:
                    dp[i][j] = dp[i+1][j+1]+1
                else:
                    dp[i][j] = max(dp[i+1][j], dp[i][j+1])
                
        return dp[0][0]
        
        