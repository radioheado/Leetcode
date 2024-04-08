class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        queue = collections.deque(students)
        stack = collections.deque(sandwiches)

        prev = len(queue)
        this_round = 0
        while prev != this_round:
            this_round = len(queue)
            for _ in range(this_round):
                if queue[0] == stack[0]:
                    stack.popleft()
                    queue.popleft()
                    prev -= 1
                else:
                    queue.append(queue.popleft())
            
        return this_round