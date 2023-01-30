from sortedcontainers import SortedList
from bisect import bisect_left

class SummaryRanges:

    def __init__(self):
        self.intervals = SortedList()

    def addNum(self, value: int) -> None:
        if not self.intervals:
            self.intervals.add([value, value])
        else:
            idx = bisect_left(self.intervals, [value, value])
            
            if idx == 0:
                # value is already included
                if value == self.intervals[0][0]:
                    pass

                # value should decrement the first interval's start
                elif value == self.intervals[0][0] - 1:
                    self.intervals[0][0] -= 1
                    
                # value should be inserted to the head by itself
                elif value < self.intervals[0][0]:
                    self.intervals.add([value, value])

                

            elif idx == len(self.intervals):
                # value is already included
                if value <= self.intervals[-1][1]:
                    pass

                # value should increment the last interval's end
                elif value == self.intervals[-1][1] + 1:
                    self.intervals[-1][1] += 1
                    
                # value should be inserted to the end by itself
                elif value > self.intervals[-1][1]:
                    self.intervals.add([value, value])

            else:
                # value is already included
                if value <= self.intervals[idx - 1][1] or value == self.intervals[idx][0]:
                    pass

                # value connects left and right intervals
                elif self.intervals[idx - 1][1] + 1 == value == self.intervals[idx][0] - 1:
                    right = self.intervals.pop(idx)
                    left  = self.intervals.pop(idx - 1)
                    self.intervals.add([left[0], right[1]])

                # value should increment left interval's end
                elif self.intervals[idx - 1][1] + 1 == value:
                    self.intervals[idx - 1][1] += 1

                # value should decrement right interval's start
                elif value == self.intervals[idx][0] - 1:
                    self.intervals[idx][0] -= 1

                else:
                    self.intervals.add([value, value])
     
    def getIntervals(self) -> List[List[int]]:
        return self.intervals


# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(value)
# param_2 = obj.getIntervals()