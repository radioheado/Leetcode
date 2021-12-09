# backtrack it from the end of nums
# initial last index that must be reached is len(nums)-1
# then visit the nodes backwards
# the current node has index i, and value nums[i]
# if i+nums[i] >= last_index, then the current last index 
# that must be reached can be reached from node i
# then we set last to i, and continue visiting
# when we finish the for loop
# if last_index == 0, return True because it's the start
        
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        last = len(nums)-1
        
        for i in range(len(nums)-1, -1, -1):
            if i+nums[i] >= last:
                last = i
                
        return last == 0
            
        