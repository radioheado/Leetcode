class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = deque([0])
        i, L, mx = 1, len(nums), max(nums)
        ans = [-1] * L
        
        while i < 2*L:
            #print("cur = ", nums[i%L])
            while stack and nums[i%L] > nums[stack[-1]]:
                ans[stack.pop()] = nums[i%L]
            
            
            if nums[i%L] == mx:
                i += 1
                continue
            if ans[i%L] != -1:
                i += 1
                continue
                
            stack.append(i%L)
            i += 1
            #print(stack)
            
        return ans
            