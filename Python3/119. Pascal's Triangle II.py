class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        prev = [1]
        
        for r in range(1, rowIndex+1):
            temp = [1]
            
            for i in range(1, r):
                #print("i = ",i)
                temp.append(prev[i-1] + prev[i])
            
            temp.append(1)
            prev = temp
            
        return prev