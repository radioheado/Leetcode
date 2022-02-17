class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans = []
        
        def backtrack(cur, total, start):
            if total == target:
                ans.append(cur[:])
                return
            elif total > target:
                return
                
            for i in range(start, len(candidates)):
                cur.append(candidates[i])
                total += candidates[i]
                backtrack(cur, total, i)
                total -= candidates[i]
                cur.pop()
                
        backtrack([], 0, 0)
        return ans
            