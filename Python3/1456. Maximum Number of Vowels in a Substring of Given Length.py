class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        l, count, ans = 0, 0, 0
        vowels = set('aeiou')

        for r, c in enumerate(s):
            if c in vowels:
                count += 1

            if r - l + 1 > k:
                if s[l] in vowels:
                    count -= 1
                l += 1

            ans = max(ans, count)

        return ans