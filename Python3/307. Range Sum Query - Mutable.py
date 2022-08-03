class NumArray:

    def __init__(self, nums: List[int]): 
        self.l = len(nums)
        self.tree = [0] * self.l * 2
        for i in range(self.l):
            self.tree[i+self.l] = nums[i]
        
        for i in range(self.l-1, 0, -1): 
            self.tree[i] = self.tree[i*2] + self.tree[i*2+1]
        #print(self.tree)
        
    def update(self, index: int, val: int) -> None:
        index += self.l
        self.tree[index] = val
        
        while index:
            l = r = index
            if index % 2:
                l = index-1
            else:
                r = index+1
                
            self.tree[index//2] = self.tree[l] + self.tree[r]
            index //= 2

    def sumRange(self, l: int, r: int) -> int:
        l += self.l
        r += self.l
        s  = 0
        
        while l <= r:
            if l % 2 == 1:
                s += self.tree[l]
                l += 1
            
            if r % 2 == 0:
                s += self.tree[r]
                r -= 1
            l //= 2
            r //= 2
            
        return s

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)