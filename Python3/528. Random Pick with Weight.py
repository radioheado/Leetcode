class Solution:

    def __init__(self, w: List[int]):
        pre = 0
        self.array = []
        
        for n in w:
            pre += n
            self.array.append(pre)
            
        #print(self.array)

    def pickIndex(self) -> int:
        _sum = random.random()*self.array[-1]
        left, right = 0, len(self.array)-1
        
        while left < right:
            mid = (right-left)//2 + left
            if self.array[mid] > _sum:
                right = mid
            else:
                left = mid+1
        
        return left
        
# Your Solution object will be instantiated and called as such:
# obj = Solution(w)
# param_1 = obj.pickIndex()