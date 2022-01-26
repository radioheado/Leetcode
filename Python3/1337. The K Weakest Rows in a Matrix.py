class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        soldiers = []
        i = 0
        
        # record the information: (i-th row, number of soldiers)
        for row in mat:
            soldiers.append((i, row.count(1)))
            i += 1
            
        soldiers.sort(key = lambda x: (x[1], x[0]))
        
        #print(soldiers)
        
        return [x[0] for x in soldiers[:k]]

        