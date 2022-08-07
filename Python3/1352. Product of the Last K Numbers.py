class ProductOfNumbers:

    def __init__(self):
        self.nums = []
        self.zero = -1
        self.size = 0

    def add(self, num: int) -> None:
        if num == 0:
            # any product before this point will be 0
            self.zero = self.size
            self.nums.append(1)
        else:
            if not self.nums:
                self.nums.append(num)
            else:
                self.nums.append(num * self.nums[-1])
                
        self.size += 1

    def getProduct(self, k: int) -> int:
        if self.zero >= 0 and self.zero >= self.size - k:
            return 0
        
        return self.nums[-1] // self.nums[self.size-k-1] if self.size - k > 0 else self.nums[-1]


# Your ProductOfNumbers object will be instantiated and called as such:
# obj = ProductOfNumbers()
# obj.add(num)
# param_2 = obj.getProduct(k)