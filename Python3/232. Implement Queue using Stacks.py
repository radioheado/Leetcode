class MyQueue:

    def __init__(self):
        self.s1 = MyStack()
        self.s2 = MyStack()

    def push(self, x: int) -> None:
        # if currently s2 holds all the elements
        # we'll push them into s1 before pushing x
        if not self.s2.empty():
            while not self.s2.empty():
                self.s1.push(self.s2.pop())
        
        self.s1.push(x)

    def pop(self) -> int:
        # if currently s2 holds all the elements
        # we'll directly pop from it
        if self.s2.empty():
            while not self.s1.empty():
                self.s2.push(self.s1.pop())  
                
        return self.s2.pop()

    def peek(self) -> int:
        if self.s2.empty():
            while not self.s1.empty():
                self.s2.push(self.s1.pop())  
                
        return self.s2.peek()

    def empty(self) -> bool:
        return self.s1.empty() and self.s2.empty()


class MyStack:
    
    def __init__(self):
        self.stack = []
        
    def push(self, x):
        self.stack.append(x)
        
    def pop(self):
        if self.stack:
            return self.stack.pop()
    
    def peek(self):
        return self.stack[-1]
    
    def empty(self):
        return len(self.stack) == 0
        
        
        
# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()