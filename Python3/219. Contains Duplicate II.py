class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        dups = {}
        for i, n in enumerate(nums):
            
            if n in dups:
                if i - dups[n] <= k:
                    return True
            dups[n] = i
            
        return False