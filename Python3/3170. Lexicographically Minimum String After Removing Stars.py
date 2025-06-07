class Solution:
    def clearStars(self, s: str) -> str:
        heap = []
        ans = list(s)

        for i, c in enumerate(s):
            if c == '*':
                _, to_remove = heappop(heap)
                ans[-to_remove] = ''
                ans[i] = ''

            else:
                heappush(heap, (c, -i))

        return ''.join(ans)