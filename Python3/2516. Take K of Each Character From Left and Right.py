class Solution:
    def takeCharacters(self, s: str, k: int) -> int:
        count = [0] * 3
        for c in s:
            count[ord(c) - ord('a')] += 1

        # Special case
        for c in count:
            if c < k:
                return -1

        ans = l = 0
        for r, c in enumerate(s):
            count[ord(c) - ord('a')] -= 1
            while l <= r and count[ord(c) - ord('a')] < k:
                count[ord(s[l]) - ord('a')] += 1
                l += 1
            
            if count[ord(c) - ord('a')] >= k:
                ans = max(ans, r - l + 1)

        return len(s) - ans
