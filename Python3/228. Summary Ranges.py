class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        # edge case
        if not nums:
            return []
        
        start = nums[0]
        ans = []
        
        for i in range(1, len(nums)):
            #print("start = %s, nums[i] = %s" %(start, nums[i]))
            # not contiguous
            if nums[i] != nums[i-1]+1:
                if nums[i-1] != start:
                    ans.append(str(start) + '->' + str(nums[i-1]))
                else:
                    ans.append(str(start))
                start = nums[i]
                
        #print("start = %s, nums[-1] = %s" %(start, nums[-1]))
        if nums[-1] != start:
            ans.append(str(start) + '->' + str(nums[-1]))
        else:
            ans.append(str(start))
            
        return ans
            