class SmallestInfiniteSet:

    def __init__(self):
        self.cur = 1
        self.heap = []
        self.set = set()

    def popSmallest(self) -> int:
        if self.heap:
            potential = self.heap[0]
            if potential < self.cur:
                self.set.discard(potential)
                return heapq.heappop(self.heap)
            
        self.cur += 1
        return self.cur - 1

    def addBack(self, num: int) -> None:
        if num not in self.set and num < self.cur:
            self.set.add(num)
            heapq.heappush(self.heap, num)


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)