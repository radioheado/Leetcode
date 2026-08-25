class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        ns = set(nums)
        num = k

        while num in ns:
            num += k
        
        return num