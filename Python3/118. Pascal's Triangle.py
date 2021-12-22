class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        result = [[1]]
        if numRows == 1:
            return result
        
        
        for n in range(2, numRows+1):
            prev = len(result[-1])
            temp = [None]*(prev+1)
            temp[0] = temp[-1] = 1
            
            for i in range(1, prev):
                #print("i = ", i)
                temp[i] = result[prev-1][i-1]+result[prev-1][i]
            #print(temp)
            prev += 1
            result.append(temp)
                
        return result
        