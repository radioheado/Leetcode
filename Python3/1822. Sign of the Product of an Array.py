class Solution:
    def arraySign(self, nums: List[int]) -> int:
        neg = 0
        for n in nums:
            if n < 0:
                neg += 1
            elif n == 0:
                return 0
            
        return -1 if neg%2 else 1
            