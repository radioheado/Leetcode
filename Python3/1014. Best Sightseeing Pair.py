class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        # logic: value n at i will become (n-(j-i)) at j
        #        keep track of this descending local max
        #        and update it if current value is bigger
        #        also update the answer if encounter larger local max + current
        lmax, ans = values[0], 0
        
        for n in values[1:]:
            ans = max(ans, lmax-1+n)
            lmax = max(lmax-1, n)
            
        return ans
            