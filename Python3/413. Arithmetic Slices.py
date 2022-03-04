class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        L = len(nums)
        
        if L < 3:
            return 0
        
        diff = None
        start = 0
        ans = 0
        
        for i in range(1, L):
            # start a new potential subarray
            if nums[i] - nums[i-1] != diff:
                
                # only count to answer if the length of subarray is 
                # longer than or equal to 3
                if i-start+1 >= 3:
                    ans += ((i-start-1) * (i-start-2)) // 2
                
                diff = nums[i] - nums[i-1]
                start = i-1
            #print("diff = %d, i = %d, start = %d, ans = %d" %(diff, i, start, ans))
        
        if L-start >= 3:
            ans += ((L-start-1) * (L-start-2)) // 2
            
        return ans