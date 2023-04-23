class Solution:
    def numberOfArrays(self, s: str, k: int) -> int:
        m, n = len(s), len(str(k))
        mod = 10**9 + 7
        dp = [0] * (m + 1)

        def dfs(start):
            # we have already computed dp[start]
            if dp[start] != 0:
                return dp[start]

            # reach to the end of s
            if start == m:
                return 1

            # current is '0', which cannot be a breakpoint
            if s[start] == '0':
                return 0

            count = 0
            for end in range(start, m):
                cur = s[start: end + 1]
                if int(cur) > k:
                    break
                count += dfs(end + 1)
            
            dp[start] = count % mod
            return count

        return dfs(0) % mod