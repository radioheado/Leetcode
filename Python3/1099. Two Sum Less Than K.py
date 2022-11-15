class Solution:
    def twoSumLessThanK(self, nums: List[int], k: int) -> int:
        if len(nums) < 2:
            return -1
        
        count = [0] * 1001
        for n in nums:
            count[n] += 1
            
        l, r = 1, 1000
        ans = -1
        
        while l <= r:
            # decrement right pointer to search the left half
            if l + r >= k or count[r] == 0:
                r -= 1
            else:
                # we need 2 or more counts for this number
                if l == r:
                    if count[l] > 1:
                        ans = max(ans, l * 2)
                else:
                    if count[l] > 0:
                        ans = max(ans, l + r)
                    
                l += 1
                
        return ans
                    