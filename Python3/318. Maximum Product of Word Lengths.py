class Solution:
    def maxProduct(self, words: List[str]) -> int:
        N = len(words)
        masks = [0] * N
        lens = [0] * N
        bitnum = lambda ch: ord(ch) - ord('a')
        
        for i in range(N):
            # l is the length of words[i]
            l = bitmask = 0
            for c in words[i]:
                l += 1
                bitmask |= 1 << bitnum(c)
            masks[i] = bitmask
            lens[i] = l
            
        ans = 0
        for i in range(N):
            for j in range(i+1, N):
                if masks[i] & masks[j] == 0:
                    ans = max(ans, lens[i] * lens[j])
                    
        return ans