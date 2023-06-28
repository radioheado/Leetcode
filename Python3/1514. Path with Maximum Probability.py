class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start: int, end: int) -> float:
        adjs = defaultdict(dict)
        heap = []
        visited = defaultdict(int)
        visited[start] = 1

        for i, [u, v] in enumerate(edges):
            adjs[u][v] = succProb[i]
            adjs[v][u] = succProb[i]

        for adj, p in adjs[start].items():
            heapq.heappush(heap, (-p, adj))
            visited[adj] = p        
        
        while heap:
            prob, v = heapq.heappop(heap)
            prob *= -1
            
            if v == end:
                return prob

            for adj, p in adjs[v].items():
                if adj not in visited or visited[adj] < prob * p:
                    visited[adj] = prob * p
                    heapq.heappush(heap, (-prob * p, adj))

        return visited[end] if end in visited else 0
        