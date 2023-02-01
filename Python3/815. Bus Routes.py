class Solution:
    def numBusesToDestination(self, routes: List[List[int]], source: int, target: int) -> int:
        # special case
        if source == target:
            return 0

        stops = collections.defaultdict(set)
        routes = list(map(set, routes))

        for i, r1 in enumerate(routes):
            for j, r2 in enumerate(routes[i+1:], i + 1):
                if r1.intersection(r2):
                    stops[i].add(j)
                    stops[j].add(i)

        visited, targets = set(), set()
        for bus, route in enumerate(routes):
            if source in route:
                visited.add(bus)
            if target in route:
                targets.add(bus)

        q = deque([(node, 1) for node in visited]) 
        
        while q:
            cur, path = q.popleft()
            if cur in targets:
                return path
            
            for nei in stops[cur]:
                if nei not in visited:
                    visited.add(nei)
                    q.append((nei, path + 1))

        return -1