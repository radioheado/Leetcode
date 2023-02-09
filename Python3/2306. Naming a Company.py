class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        suffix = [set() for _ in range(26)]

        for i in ideas:
            suffix[ord(i[0]) - ord('a')].add(i[1:])

        ans = 0
        for i in range(26):
            for j in range(i + 1, 26):
                same = len(suffix[i] & suffix[j])
                ans += 2 * (len(suffix[i]) - same) * (len(suffix[j]) - same)

        return ans