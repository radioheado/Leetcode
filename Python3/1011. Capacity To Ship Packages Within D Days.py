class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:

        def shippable(capacity: int) -> bool:
            day, load = 1, 0
            for w in weights:
                load += w
                if load > capacity:
                    day += 1
                    load = w

            return day <= days

        maxWeight, totalWeight = 0, 0
        for w in weights:
            maxWeight = max(maxWeight, w)
            totalWeight += w

        l, r = maxWeight, totalWeight
        while l < r:
            m = (r - l) // 2 + l
            if shippable(m):
                r = m
            else:
                l = m + 1

        return l