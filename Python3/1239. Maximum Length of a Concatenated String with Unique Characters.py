class Solution:
    def maxLength(self, arr: List[str]) -> int:
        ans = 0
        
        def backtrack(start = 0, l = 0, seen = set()):
            nonlocal ans
            ans = max(ans, l)
            
            for i in range(start, len(arr)):
                sub = arr[i]
                chars = set(sub)
                
                # case 1: this subsequence itself has duplicates, start from next
                if len(sub) != len(chars):
                    backtrack(i + 1, l, seen)
                    
                # case 2: duplicates found, skip this and continue
                elif chars.intersection(seen):
                    #print(chars.intersection(seen))
                    backtrack(i + 1, l, seen)
                
                # case 3: no duplicates, continue
                else:
                    backtrack(i + 1, l + len(sub), chars.union(seen))
                    
        backtrack()
        return ans