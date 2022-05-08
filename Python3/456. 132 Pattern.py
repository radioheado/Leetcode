class Solution:
    def find132pattern(self, nums: List[int]) -> bool:
        stack = deque()
        min_arr = [nums[0]]
        for n in nums[1:]:
            min_arr.append(min(min_arr[-1], n))
                
        for i in range(len(nums)-1, -1, -1):
            if nums[i] <= min_arr[i]:
                continue
            
            while stack and stack[-1] <= min_arr[i]:
                stack.pop()
            if stack and stack[-1] < nums[i]:
                return True
            
            stack.append(nums[i])
            
        return False          