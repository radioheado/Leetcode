class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        ans = 0
        lower_last = [-1] * 26
        upper_first = [-1] * 26

        for i, c in enumerate(word):
            if c.islower():
                lower_last[ord(c) - ord('a')] = i
            else:
                if upper_first[ord(c) - ord('A')] == -1:
                    upper_first[ord(c) - ord('A')] = i

        for l, u in zip(lower_last, upper_first):
            if l != -1 and u != -1 and l < u:
                ans += 1

        return ans