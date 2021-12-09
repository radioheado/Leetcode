class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        visited = set()
        
        def dfs(i, visited):
            
            if i in visited or i < 0 or i >= len(arr):
                return
            
            if arr[i] == 0:
                return True
            
            visited.add(i)
            
            #print(i ,visited)
            
            return dfs(i+arr[i], visited) or dfs(i-arr[i], visited)
        
        return dfs(start, visited)