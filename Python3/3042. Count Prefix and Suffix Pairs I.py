class Solution:
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        ans = 0
        N = len(words)

        for i, word in enumerate(words):
            for j in range(i + 1, N):
                n = len(word)
                l = len(words[j])

                if n > l:
                    continue
                
                if words[j][:n] == word and words[j][l - n:] == word:
                    ans += 1

        return ans