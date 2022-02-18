class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        nums = [1,2,3,4,5,6,7,8,9]
        ans = []
        
        def backtrack(start=0, cur=[], total=0):
            #print(cur)
            if len(cur) == k and total == n:
                ans.append(cur[:])
                return
            elif len(cur) >= k or total >= n:
                return
            
            for i in range(start, len(nums)):
                cur.append(nums[i])
                total += nums[i]
                backtrack(i+1, cur, total)
                total -= nums[i]
                cur.pop()
                
        backtrack()
        return ans