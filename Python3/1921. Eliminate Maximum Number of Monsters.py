class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        times = [d/s for d, s in zip(dist, speed)]
        times.sort()

        ans = 0
        for i, t in enumerate(times):
            if t <= i:
                break

            ans += 1

        return ans