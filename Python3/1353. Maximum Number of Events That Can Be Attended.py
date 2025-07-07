class Solution:
    def maxEvents(self, events: List[List[int]]) -> int:
        max_day = max(event[1] for event in events)
        events.sort()
        heap = []
        ans = j = 0
        n = len(events)

        for i in range(1, max_day + 1):
            while j < n and events[j][0] <= i:
                heapq.heappush(heap, events[j][1])
                j += 1

            while heap and heap[0] < i:
                heapq.heappop(heap)
            
            if heap:
                heapq.heappop(heap)
                ans += 1

        return ans