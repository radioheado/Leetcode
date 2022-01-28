# binary search + insertion search
class MedianFinder:

    def __init__(self):
        self.nums = []
        

    def addNum(self, num: int) -> None:
        if not self.nums:
            self.nums.append(num)
        else:
            left = bisect.bisect_left(self.nums, num, 0, len(self.nums))
            self.nums = self.nums[:left] + [num] + self.nums[left:]

    def findMedian(self) -> float:
        l = len(self.nums)
        if l == 1:
            return self.nums[0]
        
        mid = l//2
        if l%2:
            return self.nums[mid]
        else:
            return (self.nums[mid]+self.nums[mid-1])/2


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()