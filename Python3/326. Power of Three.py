class Solution:
    def __init__(self):
        self.nums = [1]
        for _ in range(19):
            self.nums.append(self.nums[-1] * 3)
        
    def isPowerOfThree(self, n: int) -> bool:
        return n in self.nums