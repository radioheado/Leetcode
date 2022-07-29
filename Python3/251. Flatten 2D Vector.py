class Vector2D:

    def __init__(self, vec: List[List[int]]):
        self.vec = vec
        self.p1  = 0
        self.p2  = 0
        
    def next(self) -> int:
        val = self.vec[self.p1][self.p2]
        # reach to the end of current sub vec
        if self.p2 == len(self.vec[self.p1]) - 1:
            self.p1 += 1
            # skip the empty sub vecs if applicable
            while self.p1 < len(self.vec) and not self.vec[self.p1]:
                self.p1 += 1
                
            # point to the first element in the newest unempty sub vec
            self.p2 = 0
            
        else:
            self.p2 += 1
            
        return val

    def hasNext(self) -> bool:
        if not self.vec:
            return False
        
        # skip the empty sub vecs if applicable
        while self.p1 < len(self.vec) and not self.vec[self.p1]:
            self.p1 += 1
            self.p2 = 0
            
        #print(self.p1, self.p2, self.vec[self.p1])
        # reach to the last element
        if self.p1 >= len(self.vec) or (self.p1 == len(self.vec)-1 and self.p2 == len(self.vec[self.p1])):
            return False
        
        #print(self.vec[self.p1], self.p1, self.p2)
        return True


# Your Vector2D object will be instantiated and called as such:
# obj = Vector2D(vec)
# param_1 = obj.next()
# param_2 = obj.hasNext()