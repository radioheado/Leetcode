class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        ans = []
        
        def backtrack(cur, start, total):
            if total == target:
                ans.append(cur[:])
                return
            elif total > target:
                return
            
            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i-1]:
                    continue
                
                cur.append(candidates[i])
                total += candidates[i]
                backtrack(cur, i+1, total)
                total -= candidates[i]
                cur.pop()
                
        backtrack([], 0, 0)
        return ans
                