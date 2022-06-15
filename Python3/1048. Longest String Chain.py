class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        # special case
        if len(words) == 1:
            return 1
        
        words.sort(key = lambda x: len(x))
        dp = collections.defaultdict(int)
        longest = 1
        
        for word in words:
            cur = 1
            for i, c in enumerate(word):
                pred = word[:i] + word[i+1:]
                prev = dp.get(pred, 0)
                cur  = max(cur, prev+1)
            dp[word] = cur
            longest = max(longest, cur)
            
        return longest
        