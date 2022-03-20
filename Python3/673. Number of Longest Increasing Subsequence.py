class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        
        L = len(nums)
        # dp array of length at i-th num
        dpl = [1] * L
        
        # dp array of ways to get to i-th num
        dpw = [1] * L
        mx = 1
        
        for i in range(1, L):
            for j in range(i):
                if nums[i] > nums[j]:
                    if dpl[i] < dpl[j]+1:
                        dpl[i] = dpl[j]+1
                        dpw[i] = dpw[j]
                    elif dpl[i] == dpl[j]+1:
                        dpw[i] += dpw[j]
            # update longest length
            mx = max(mx, dpl[i])
            
        #print(dp) 
        ans = 0
        for i in range(L):
            if dpl[i] == mx:
                ans += dpw[i]
                
        return ans