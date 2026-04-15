class Solution:
    def closestTarget(self, words: List[str], target: str, startIndex: int) -> int:
        N = len(words)

        for i in range(N):
            l = (startIndex - i + N) % N
            r = (startIndex + i) % N

            if words[l] == target or words[r] == target:
                return i

        return -1