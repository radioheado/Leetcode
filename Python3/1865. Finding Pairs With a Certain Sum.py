class FindSumPairs:

    def __init__(self, nums1: List[int], nums2: List[int]):
        self.count1 = Counter(nums1)
        self.sorted1 = list(self.count1.keys())
        self.sorted1.sort()
        self.count2 = Counter(nums2)
        self.nums2 = nums2

    def add(self, index: int, val: int) -> None:
        num = self.nums2[index]
        self.nums2[index] += val
        self.count2[num] -= 1
        self.count2[num + val] += 1

    def count(self, tot: int) -> int:
        ans = 0
        for n in self.sorted1:
            if n > tot:
                break

            ans += self.count1[n] * self.count2[tot - n]

        return ans


# Your FindSumPairs object will be instantiated and called as such:
# obj = FindSumPairs(nums1, nums2)
# obj.add(index,val)
# param_2 = obj.count(tot)