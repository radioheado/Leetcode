class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        top = sec = -1
        for n in nums:
            if n >= top:
                sec = top
                top = n
            elif n > sec:
                sec = n

        return (top - 1) * (sec - 1)