class MyStack:

    def __init__(self):
        self.q = MQueue()

    def push(self, x: int) -> None:
        s = self.q.size()
        self.q.push(x)
        
        while s:
            self.q.push(self.q.pop())
            s -= 1
        
    def pop(self) -> int:
        return self.q.pop()

    def top(self) -> int:
        return self.q.top()

    def empty(self) -> bool:
        return self.q.empty()


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()

class MQueue:
    
    def __init__(self):
        self.queue = []
        self.s = 0
        
    def push(self, x: int) -> None:
        self.queue.append(x)
        self.s += 1

    def pop(self) -> int:
        self.s -= 1
        return self.queue.pop(0)

    def top(self) -> int:
        return self.queue[0]

    def empty(self) -> bool:
        return len(self.queue)==0
    
    def size(self) -> int:
        return self.s