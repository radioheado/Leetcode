class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        n = len(arr)
        m = arr[n-1]
        arr[n-1] = -1
        
        for i in range(n-2, -1, -1):
            arr[i], m = m, max(m, arr[i])
            
        return arr
                