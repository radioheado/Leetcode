class Solution:
    def slowestKey(self, releaseTimes: List[int], keysPressed: str) -> str:
        time = releaseTimes[0]
        ans = keysPressed[0]

        for i, r in enumerate(releaseTimes[1:], 1):
            if r - releaseTimes[i-1] > time:
                time = r - releaseTimes[i-1]
                ans = keysPressed[i]

            elif r - releaseTimes[i-1] == time:
                ans = max(ans, keysPressed[i])

        return ans