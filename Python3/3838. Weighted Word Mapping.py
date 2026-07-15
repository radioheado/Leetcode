class Solution:
    def mapWordWeights(self, words: List[str], weights: List[int]) -> str:
        ans = ''
        for word in words:
            _sum = 0
            for c in word:
                _sum += weights[ord(c) - ord('a')]
            _sum = 25 - _sum % 26
            ans += chr(ord('a') + _sum)

        return ans
