class Solution:
    def countSubstrings(self, s: str) -> int:
        n = len(s)
        
        dp = [[0] * n for _ in range(n)]
        ans = 0
        
        for i in range(n-1, -1, -1):
            for j in range(i, n):
                # case 1: one char
                if i == j:
                    dp[i][j] = 1
                
                # case 2: two identical chars
                elif j-i == 1:
                    dp[i][j] = s[i] == s[j]
                
                # case 3: a palindrome with two surrounding identical chars
                else:
                    dp[i][j] = dp[i+1][j-1] and s[i] == s[j]
                    
                if dp[i][j]:
                    ans += 1
                    
        return ans
        