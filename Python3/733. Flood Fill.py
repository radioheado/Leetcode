# Recursive Solution
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
                
        def dfs(r, c):
            if image[r][c] == color:
                image[r][c] = newColor

                if r-1 >= 0:
                    dfs(r-1, c)
                if r+1 < len(image):
                    dfs(r+1, c)
                if c-1 >= 0:
                    dfs(r, c-1)
                if c+1 < len(image[0]):
                    dfs(r, c+1)
                
        color = image[sr][sc]
        if color == newColor:   return image
        dfs(sr, sc)
        return image

# Iterative Solution
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        color = image[sr][sc]
        if color == newColor:   return image
        
        q = deque([(sr, sc)])
        
        while q:
            r, c = q.popleft()
            if image[r][c] == color:
                image[r][c] = newColor
                
                if r-1 >= 0:
                    q.append((r-1, c))
                if r+1 < len(image):
                    q.append((r+1, c))
                if c-1 >= 0:
                    q.append((r, c-1))
                if c+1 < len(image[0]):
                    q.append((r, c+1))
                    
        return image
                    
        