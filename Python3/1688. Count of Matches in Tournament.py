class Solution:
    def numberOfMatches(self, n: int) -> int:
        ans = 0

        while n > 1:
            ans += n // 2

            # odd
            if n % 2:
                n += 1

            n //= 2
            
            
        return ans