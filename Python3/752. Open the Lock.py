class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        
        # get the four neighbors of the current node
        def neighbors(node):
            for i in range(4):
                
                # get the integer representation of one of the four digits 
                x = int(node[i])
                
                # increment or decrement it 
                for j in (-1, 1):
                    y = (x+j)%10
                    yield node[:i] + str(y) + node[i+1:]
                    
        # quick check using set
        dead = set(deadends)
        
        # the initial state 
        seen = {'0000'}
        
        # use a queue to do BFS, 0 indicates the current move
        q = deque([('0000', 0)])
        
        while q:
            node, move = q.popleft()
            if node == target:
                return move
            
            # continue searching for other possible ways
            if node in dead:
                continue
                
            for nei in neighbors(node):
                if nei not in seen:
                    seen.add(nei)
                    q.append((nei, move+1))
                    
        return -1
            
        