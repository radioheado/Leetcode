class Solution:
    def hammingWeight(self, n: int) -> int:
        dis = 0
        while n:
            dis += 1
            n &= (n-1)
            
        return dis