class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        bits = [[] for _ in range(14)]
        
        for num in arr:
            #print(num, self.countOne(num))
            bits[self.countOne(num)].append(num)
        
        ans = []
        for b in bits:
            ans.extend(sorted(b))
        return ans
        
    def countOne(self, num) -> int:
        return bin(num).count('1')