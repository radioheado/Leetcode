class Solution:
    def maxBottlesDrunk(self, numBottles: int, numExchange: int) -> int:
        ans = empty = 0

        while empty + numBottles >= numExchange:
            ans += numBottles
            empty += numBottles
            if empty >= numExchange:
                numBottles = 1
                empty -= numExchange
                numExchange += 1

        return ans + numBottles