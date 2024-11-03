class Solution:
    def sameEndSubstringCount(self, s: str, queries: List[List[int]]) -> List[int]:
        N = len(s)
        chars = [[0] * N for _ in range(26)]

        for i, c in enumerate(s):
            chars[ord(c) - ord('a')][i] += 1

        for f in chars:
            for j in range(1, N):
                f[j] += f[j - 1]

        ans = []

        for s, e in queries:
            temp = 0
            for f in chars:
                s_freq = 0 if s == 0 else f[s - 1]
                e_freq = f[e]
                x = e_freq - s_freq
                temp += (x * (x + 1)) // 2
            ans.append(temp)

        return ans