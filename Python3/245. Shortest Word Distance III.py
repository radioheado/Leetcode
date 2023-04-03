class Solution:
    def shortestWordDistance(self, wordsDict: List[str], word1: str, word2: str) -> int:
        ans = len(wordsDict)
        i1, i2 = -ans, ans
        same = word1 == word2

        for i, w in enumerate(wordsDict):
            if word1 == w:
                if same:
                    i2 = i1
                i1 = i
            elif word2 == w:
                i2 = i
            ans = min(ans, abs(i2 - i1))
            
        return ans