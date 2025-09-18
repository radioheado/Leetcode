class TaskManager:

    def __init__(self, tasks: List[List[int]]):
        # taskId: (priority, userId)
        self.task_map = {}

        # max heap
        self.priority_heap = []
        for userId, taskId, priority in tasks:
            self.add(userId, taskId, priority)

    def add(self, userId: int, taskId: int, priority: int) -> None:
        self.task_map[taskId] = (priority, userId)
        heappush(self.priority_heap, (-priority, -taskId))

    def edit(self, taskId: int, newPriority: int) -> None:
        if taskId in self.task_map:
            _, userId = self.task_map[taskId]
            self.task_map[taskId] = (newPriority, userId)
            heappush(self.priority_heap, (-newPriority, -taskId))

    def rmv(self, taskId: int) -> None:
        # Lazy delete
        if taskId in self.task_map:
            del self.task_map[taskId]

    def execTop(self) -> int:
        while self.priority_heap:
            nprio, ntask = heappop(self.priority_heap)

            # Complete the lazy delete
            if -ntask not in self.task_map:
                continue

            priority, userId = self.task_map[-ntask]
            if priority == -nprio:
                del self.task_map[-ntask]
                return userId

        return -1


# Your TaskManager object will be instantiated and called as such:
# obj = TaskManager(tasks)
# obj.add(userId,taskId,priority)
# obj.edit(taskId,newPriority)
# obj.rmv(taskId)
# param_4 = obj.execTop()