class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        adjs = defaultdict(list)
        for s, d, p in flights:
            adjs[s].append((d, p))

        stops = [inf] * n

        # tuple: (distance_from_source, node, stops_from_source)
        heap = [(0, src, 0)]

        while heap:
            dist, node, stop = heapq.heappop(heap)
            if stop > stops[node] or stop > k + 1:
                continue

            stops[node] = stop
            if node == dst:
                return dist

            for nei, price in adjs[node]:
                heapq.heappush(heap, (dist + price, nei, stop + 1))
            
        return -1