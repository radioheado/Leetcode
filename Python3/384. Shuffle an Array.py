class Solution:

    def __init__(self, nums: List[int]):
        self.original = list(nums)
        self.array = nums

    def reset(self) -> List[int]:
        self.array = self.original
        self.original = list(self.original)
        return self.array

    def shuffle(self) -> List[int]:
        copy = list(self.array)
        for i in range(len(self.array)):
            removed = random.randrange(len(copy))
            self.array[i] = copy.pop(removed)
        return self.array


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.reset()
# param_2 = obj.shuffle()