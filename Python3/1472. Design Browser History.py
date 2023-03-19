class BrowserHistory:

    def __init__(self, homepage: str):
        self.stack = [homepage]
        self.ptr = 0
        self.size = 1

    def visit(self, url: str) -> None:
        while self.ptr < self.size - 1:
            self.stack.pop()
            self.size -= 1

        self.stack.append(url)
        self.ptr = self.size
        self.size += 1
       

    def back(self, steps: int) -> str:
        self.ptr = max(0, self.ptr - steps)
        return self.stack[self.ptr]

    def forward(self, steps: int) -> str:
        self.ptr = min(self.size - 1, self.ptr + steps)
        return self.stack[self.ptr]


# Your BrowserHistory object will be instantiated and called as such:
# obj = BrowserHistory(homepage)
# obj.visit(url)
# param_2 = obj.back(steps)
# param_3 = obj.forward(steps)