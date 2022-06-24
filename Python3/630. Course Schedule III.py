class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        courses.sort(key = lambda x:(x[1], x[0]))
        # max heap
        heap = []
        time = 0
        
        for dura, end in courses:
            if time + dura <= end:
                time += dura
                heapq.heappush(heap, -dura)
            elif heap and -heap[0] > dura:
                time += dura + heapq.heappop(heap)
                heapq.heappush(heap, -dura)
                
        return len(heap)