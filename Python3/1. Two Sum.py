class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        indices = {}
        
        # solve it in one pass   
        # search for its complement num before add itself
        for i, n in enumerate(nums):
            comp = target - n
            if comp in indices:
                return [i, indices[comp]]
            
            # add this number to indices for future searches
            indices[n] = i