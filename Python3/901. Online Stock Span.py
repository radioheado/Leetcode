class StockSpanner:

    def __init__(self):
        self.stack = []
        self.size  = 0

    def next(self, price: int) -> int:
        self.size += 1
        while self.stack and self.stack[-1][0] <= price:
            self.stack.pop()
            
        res = self.size if not self.stack else self.size - self.stack[-1][1]
        self.stack.append((price, self.size))
        return res

# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)