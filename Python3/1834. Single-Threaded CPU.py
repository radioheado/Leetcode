class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        # heap tuple: (processing time, index)
        enqueuedTasks = []
        ans = []

        # sorted tuple: (enqueue time, processing time, index)
        sortedTasks = [(enque, process, idx) for idx, (enque, process) in enumerate(tasks)]
        sortedTasks.sort()

        curTime = 0
        taskIdx = 0

        # stop condition: no more tasks in both heap and queue
        while taskIdx < len(tasks) or enqueuedTasks:
            # skip the idle time
            if not enqueuedTasks and curTime < sortedTasks[taskIdx][0]:
                curTime = sortedTasks[taskIdx][0]

            # push all tasks that enqueue by curTime to the heap
            while taskIdx < len(tasks) and curTime >= sortedTasks[taskIdx][0]:
                _, process, idx = sortedTasks[taskIdx]
                taskIdx += 1
                heapq.heappush(enqueuedTasks, (process, idx))

            process, idx = heapq.heappop(enqueuedTasks)
            # complete current task and increase curTime
            curTime += process
            ans.append(idx)
        
        return ans