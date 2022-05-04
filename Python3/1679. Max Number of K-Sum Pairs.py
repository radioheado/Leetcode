class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        counts = collections.Counter(nums)
        ans = 0
        
        for n, c in counts.items():
            if n >= k:
                continue
            
            comp = k-n
            # n's complement is itself
            if comp == n:
                counts[n] -= c//2
                ans += c//2
            
            # n's complement 
            elif k-n in counts and counts[k-n] > 0:
                op = min(counts[k-n], c)
                ans += op
                counts[k-n] -= op
                counts[n] -= op
        
        return ans
                