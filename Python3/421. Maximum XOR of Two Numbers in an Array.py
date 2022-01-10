class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        maxNum = max(nums)
        
        # get the maximum binary length in nums
        maxBit = len(bin(maxNum))-2
        
        root = Trie()
        # left-pad zeroes to every binary number
        for n in nums:
            root.insert(n, maxBit)
        
        ans = -1
        
        for n in nums:
            n = bin(n)[2:].zfill(maxBit)
            r = root.find(n)
            #print(r)
            ans = max(ans, r)
            
        return ans
        
        
        
        
class Trie:
    
    def __init__(self):
        self.children = collections.defaultdict(Trie)
        
    def insert(self, num, pad):
        cur = self
        for b in bin(num)[2:].zfill(pad):
            cur = cur.children[b]
            
    def find(self, binary):
        res = 0
        cur = self
        for b in binary:
            if b == '1':
                if '0' in cur.children:
                    res = res*2 + 1
                    cur = cur.children['0']
                else:
                    res = res*2
                    cur = cur.children['1']
            else:
                if '1' in cur.children:
                    res = res*2 + 1
                    cur = cur.children['1']
                else:
                    res = res*2
                    cur = cur.children['0']
        return res
            