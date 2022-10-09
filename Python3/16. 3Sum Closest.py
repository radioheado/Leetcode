class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        if len(nums) <= 3:
            return sum(nums)
        
        nums.sort()
        ans = inf
        L = len(nums)
        
        for i in range(L-2):
            l, r = i+1, L-1
            while l < r:
                temp = nums[i] + nums[l] + nums[r]
                if abs(temp - target) < abs(ans - target):
                    ans = temp
                
                if temp > target:
                    r -= 1
                elif temp < target:
                    l += 1
                else:
                    return target
                
        return ans