class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        # maintain (capital, profit) for each project ascendingly
        projects = list(zip(capital, profits))
        projects.sort()

        P = len(profits)

        # a max priority queue to maintain profits 
        heap = []

        # a pointer to iterate projects
        ptr = 0

        # at each step, push all projects that need a capital smaller than current w
        for _ in range(k):
            while ptr < P and projects[ptr][0] <= w:
                heapq.heappush(heap, -projects[ptr][1])
                ptr += 1

            # if there are no projects in the heap
            # it means we don't have enough capital to start any remaining projects
            if not heap:
                break
            
            # pop the current max profit from the heap and increase our capital
            # note this is a max heap so we have to negate it
            w -= heapq.heappop(heap)

        return w