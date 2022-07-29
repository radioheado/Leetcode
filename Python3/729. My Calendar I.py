class MyCalendar:

    def __init__(self):
        self.slots = []
        self.size = 0

    def book(self, start: int, end: int) -> bool:
        if not self.slots:
            self.slots.append([start, end])
            self.size += 1
            return True
        
        for i, [s, e] in enumerate(self.slots):
            # new schedule is prior to current slot
            if s > end:
                self.slots.insert(i, [start, end])
                self.size += 1
                break
            
            # new schedule ends just before current slot
            elif s == end:
                self.slots[i] = [start, e]
                break
            
            # intersect
            elif (s <= start and start < e) or (start <= s and s < end):
                return False
            
            # check for the last position
            if i == self.size-1:
                if start > e:
                    self.slots.append([start, end])
                    self.size += 1
                    break
                
                elif e == start:
                    self.slots[i] = [s, end]
                    break
                    
        return True


# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)