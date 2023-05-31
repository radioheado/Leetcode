class Bitset:

    def __init__(self, size: int):
        self.set = ['0'] * size
        self.rev = ['1'] * size
        self.ones = 0
        self.zeros = size
        self.size = size

    def fix(self, idx: int) -> None:
        if self.set[idx] != '1':
            self.zeros -= 1
            self.ones += 1
            
        self.set[idx] = '1'
        self.rev[idx] = '0'

    def unfix(self, idx: int) -> None:
        if self.set[idx] != '0':
            self.zeros += 1
            self.ones -= 1
            
        self.set[idx] = '0'
        self.rev[idx] = '1'

    def flip(self) -> None:
        self.ones, self.zeros = self.zeros, self.ones
        self.set, self.rev = self.rev, self.set

    def all(self) -> bool:
        return self.ones == self.size

    def one(self) -> bool:
        return self.ones > 0

    def count(self) -> int:
        return self.ones

    def toString(self) -> str:
        return ''.join(self.set)
        


# Your Bitset object will be instantiated and called as such:
# obj = Bitset(size)
# obj.fix(idx)
# obj.unfix(idx)
# obj.flip()
# param_4 = obj.all()
# param_5 = obj.one()
# param_6 = obj.count()
# param_7 = obj.toString()