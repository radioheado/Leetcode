class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        chars = collections.defaultdict(int)
        ans = l = distinct = 0

        for r, c in enumerate(s):
            # a new distinct char
            if chars.get(c, 0) == 0:
                chars[c] += 1
                distinct += 1

                while l < r and distinct > 2:
                    chars[s[l]] -= 1
                    if chars[s[l]] == 0:
                        distinct -= 1
                    l += 1

            else:
                chars[c] += 1

            ans = max(ans, r - l + 1)

        return ans