class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        ans = 0
        
        def backtrack(start: int, cur: int) -> None:
            if start == len(nums):
                nonlocal ans
                ans += cur
                return 

            backtrack(start + 1, cur)
            backtrack(start + 1, cur ^ nums[start])

        backtrack(0, 0)
        return ans