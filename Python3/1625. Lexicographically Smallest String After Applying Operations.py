class Solution:
    def findLexSmallestString(self, s: str, a: int, b: int) -> str:
        digits = {}
        N = len(s)

        for n in range(10):
            digits[str(n)] = str((n + a) % 10)

        def add(st: str) -> str:
            ans = ''
            for i in range(N):
                ans += st[i] if i % 2 == 0 else digits[st[i]]
            return ans

        def rotate(st: str) -> str:
            return st[N - b:] + st[:N - b]

        seen = set()

        def dfs(st):
            if st in seen:
                return

            seen.add(st)
            dfs(add(st))
            dfs(rotate(st))

        dfs(s)
        return min(seen)