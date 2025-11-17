class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        pre = -1

        for i, n in enumerate(nums):
            if n == 1:
                if pre == -1 or i - pre > k:
                    pre = i
                    continue

                return False
        
        return True