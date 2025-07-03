class Solution:
    def possibleStringCount(self, word: str) -> int:
        ans = 1
        pre = 0

        for i, c in enumerate(word[1:], 1):
            if c != word[i - 1]:
                ans += i - pre - 1
                pre = i
        
        return ans + len(word) - pre - 1