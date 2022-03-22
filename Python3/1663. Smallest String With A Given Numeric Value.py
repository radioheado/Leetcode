class Solution:
    def getSmallestString(self, n: int, k: int) -> str:
        ans = ['a'] * n
        
        for i in range(n-1, -1, -1):
            val = min(26, k-i)
            ans[i] = chr(val+ord('a')-1)
            k -= val
                
        return ''.join(ans)