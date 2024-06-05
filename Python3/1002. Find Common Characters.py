class Solution:
    def commonChars(self, words: List[str]) -> List[str]:
        chars = [0] * 26
        for c in words[0]:
            chars[ord(c) - 97] += 1

        for w in words[1:]:
            temp = [0] * 26
            for c in w:
                temp[ord(c) - 97] += 1

            for i, c in enumerate(chars):
                chars[i] = min(c, temp[i])

        ans = []
        for i, c in enumerate(chars):
            if c > 0:
                ans.extend([chr(i + 97)] * c)

        return ans