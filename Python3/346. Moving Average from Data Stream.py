class MovingAverage:

    def __init__(self, size: int):
        self.size = size
        self.window = []
        self.average = 0
        
    def next(self, val: int) -> float:
        if len(self.window) == self.size:
            self.average = (self.average*self.size-self.window[0]+val)/self.size
            self.window.pop(0)
            self.window.append(val)
        
        else:
            s = len(self.window)
            self.average = (self.average*s+val)/(s+1)
            self.window.append(val)
        
        return self.average


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)

