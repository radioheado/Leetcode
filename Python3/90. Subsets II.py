class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        ans = []
        nums.sort()
        
        def backtrack(start=0, cur=[]):
            ans.append(cur[:])
            if start == len(nums):
                return
            
            for i in range(start, len(nums)):
                # found a duplicate
                if i > start and nums[i] == nums[i-1]:
                    continue
                    
                cur.append(nums[i])
                #print(nums[i], cur)
                backtrack(i+1, cur)
                cur.pop()
                
        backtrack()
        return ans