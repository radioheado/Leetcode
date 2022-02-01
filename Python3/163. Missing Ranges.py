class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        ans = []
        
        # edge case: empty list
        if not nums:
            if lower == upper:
                ans.append(str(lower))
            else:
                ans.append(str(lower) + '->' + str(upper))
            return ans
        
        # normal cases
        if nums[0] > lower:
            right = nums[0]-1
            if right == lower:
                ans.append(str(right))
            else:
                ans.append(str(lower) + '->' + str(right))
        
        for i in range(1, len(nums)):
            if nums[i] - nums[i-1] > 1:
                left = nums[i-1]+1
                right = nums[i]-1
                if left == right:
                    ans.append(str(left))
                else:
                    ans.append(str(left) + '->' + str(right))
        
        if nums[-1] < upper:
            left = nums[-1]+1
            if left == upper:
                ans.append(str(left))
            else:
                ans.append(str(left) + '->' + str(upper))
            
        return ans