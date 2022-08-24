class Solution:
    
    def __init__(self):
        self.nums = [1] * 16
        for i in range(1, 16):
            self.nums[i] = 4 * self.nums[i-1]
        
    def isPowerOfFour(self, n: int) -> bool:
        return n in self.nums