class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        n = len(changed)
        
        if n%2 == 1:
            return []
        
        changed = Counter(changed)
        ans = []
        count = 0
        
        for num in sorted(changed):
            # check 0s
            if num == 0:
                if changed[num]%2 == 1:
                    return []
                else:
                    ans.extend([0]*(changed[num]//2))
            
            else:
                if num*2 in changed and changed[num*2] > 0:
                    min_count = min(changed[num], changed[num*2])
                    ans.extend([num]*min_count)
                    changed[num*2] -= min_count
                    changed[num] -= min_count
            
        return ans if len(ans) == n/2 else []
        