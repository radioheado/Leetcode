class Router:

    def __init__(self, memoryLimit: int):
        self.limit = memoryLimit
        self.packets = set()                    # (source, destination, timestamp)
        self.queue = deque()
        self.dest_time = defaultdict(deque)     # destination: [timestamps]


    def addPacket(self, source: int, destination: int, timestamp: int) -> bool:
        cur = (source, destination, timestamp)
        if cur in self.packets:
            return False

        while len(self.queue) >= self.limit:
            to_remove = self.queue.popleft()
            self.packets.discard(to_remove)
            self.dest_time[to_remove[1]].popleft()

        self.packets.add(cur)
        self.queue.append(cur)
        self.dest_time[destination].append(timestamp)
        return True


    def forwardPacket(self) -> List[int]:
        if not self.queue:
            return []

        to_remove = self.queue.popleft()
        self.packets.discard(to_remove)
        self.dest_time[to_remove[1]].popleft()
        return list(to_remove)


    def getCount(self, destination: int, startTime: int, endTime: int) -> int:
        timestamps = self.dest_time[destination]
        l = bisect_left(timestamps, startTime)
        r = bisect_right(timestamps, endTime)
        return r - l


# Your Router object will be instantiated and called as such:
# obj = Router(memoryLimit)
# param_1 = obj.addPacket(source,destination,timestamp)
# param_2 = obj.forwardPacket()
# param_3 = obj.getCount(destination,startTime,endTime)