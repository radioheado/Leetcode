class UndergroundSystem:

    def __init__(self):
        self.customer = collections.defaultdict(tuple)
        self.travel = collections.defaultdict(tuple)
        

    def checkIn(self, id: int, start: str, t: int) -> None:
        self.customer[id] = (start, t)
        

    def checkOut(self, id: int, end: str, t: int) -> None:
        start, time = self.customer.get(id)
        if (start, end) in self.travel:
            avg, count = self.travel[(start, end)]
            new_avg = (avg * count + t - time) / (count + 1)
            self.travel[(start, end)] = (new_avg, count+1)
        else:
            self.travel[(start, end)] = (t - time, 1)
        

    def getAverageTime(self, start: str, end: str) -> float:
        return self.travel[(start, end)][0]


# Your UndergroundSystem object will be instantiated and called as such:
# obj = UndergroundSystem()
# obj.checkIn(id,stationName,t)
# obj.checkOut(id,stationName,t)
# param_3 = obj.getAverageTime(startStation,endStation)