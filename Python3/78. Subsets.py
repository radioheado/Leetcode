class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        def backtrack(start, cur):
            ans.append(cur[:])
            
            for i in range(start, len(nums)):
                cur.append(nums[i])
                backtrack(i+1, cur)
                cur.pop()
                
        ans = []
        backtrack(0, [])
        return ans