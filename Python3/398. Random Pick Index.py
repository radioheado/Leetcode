class Solution:

    def __init__(self, nums: List[int]):
        self.indices = collections.defaultdict(list)
        for i, n in enumerate(nums):
            self.indices[n].append(i)

    def pick(self, target: int) -> int:
        # get total number
        count = len(self.indices[target])
        prob = random.random()
        index = self.indices[target][int(prob*count)]
        return index


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)