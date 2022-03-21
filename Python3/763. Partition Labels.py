class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        indices = {}
        # record the first and last occurrences of the char
        for i, c in enumerate(s):
            if c not in indices:
                indices[c] = [i, i]
            else:
                indices[c][1] = i
                
        indices = sorted(indices.values())
        #print(indices)
        
        prev = indices[0]
        ans = []
        
        for start, end in indices[1:]:
            # new interval is covered in the current partition
            if start < prev[1]:
                prev[1] = max(prev[1], end)
                
            else:
                ans.append(prev[1]-prev[0]+1)
                prev = [start, end]
        
        # add the last partition
        ans.append(prev[1]-prev[0]+1)
            
        return ans