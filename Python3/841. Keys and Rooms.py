class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        q = deque([0])
        valid = set()
        valid.add(0)
        
        while q:
            index = q.popleft()
            for key in rooms[index]:
                if key not in valid:
                    valid.add(key)
                    q.append(key)
            
        return len(valid) == len(rooms)
                