class Solution:
    def minTimeToReach(self, moveTime: List[List[int]]) -> int:
        n, m = len(moveTime), len(moveTime[0])
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        shortest = [[inf] * m for _ in range(n)]
        heap = []
        heappush(heap, (0, 0, 0))

        while heap:
            cost, row, col = heappop(heap)

            for x, y in dirs:
                r, c = row + x, col + y
                if 0 <= r < n and 0 <= c < m:
                    new_cost = max(moveTime[r][c], cost) + 1
                    if new_cost < shortest[r][c]:
                        shortest[r][c] = new_cost
                        heappush(heap, (new_cost, r, c))

        return shortest[-1][-1]