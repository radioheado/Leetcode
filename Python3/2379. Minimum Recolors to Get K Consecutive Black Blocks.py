class Solution:
    def minimumRecolors(self, blocks: str, k: int) -> int:
        l = white = 0
        ans = k

        for i, c in enumerate(blocks):
            if c == 'W':
                white += 1

            if i - l + 1 == k:
                ans = min(ans, white)
                white -= blocks[l] == 'W'
                l += 1

        return ans