class FreqStack:

    def __init__(self):
        self.freq = Counter()
        self.group = collections.defaultdict(list)
        self.most = 0

    def push(self, val: int) -> None:
        # increment the number's frequency
        frequency = self.freq[val] + 1
        self.freq[val] = frequency
        self.group[frequency].append(val)
        if frequency > self.most:
            self.most = frequency

    def pop(self) -> int:
        # get the number that appear most and last
        top = self.group[self.most].pop()
        self.freq[top] -= 1
        
        # if no more elements in the top frequency
        if not self.group[self.most]:
            self.most -= 1
        
        return top


# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()