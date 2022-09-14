class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        # attack deque: min heap
        # defense deque: max heap
        groups = defaultdict(list)
        
        for a, d in properties:
            heapq.heappush(groups[a], -d)
            
        defense = deque()
        ans = 0
        for n in sorted(groups.keys()):
            # pop the defense values in the stack who 
            # is smaller than the current biggest defense value
            while defense and defense[-1] < -groups[n][0]:
                ans += 1
                defense.pop()
            
            # push current defense value to the stack
            while groups[n]:
                defense.append(-heapq.heappop(groups[n]))
            
        return ans