class Solution:
    def intersectionSizeTwo(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x: (x[1], -x[0]))
        ans, p1, p2 = 0, -1, -1

        for s, e in intervals:
            # Case 1: No overlap. Current set has 0 intersection.
            # We need to add two numbers. Best greedy choice: end-1, end.
            if s > p2:
                ans += 2
                p1, p2 = e - 1, e

            # Case 2: Partial overlap. Current set has 1 intersection (p2).
            # We need to add one number. Best greedy choice: end.
            # Note: start > p1 implies start is between p1 and p2 (since start <= p2 failed above)
            elif s > p1:
                ans += 1
                p1, p2 = p2, e

            # Case 3: Full overlap (start <= p1).
            # Both p1 and p2 are in [start, end]. Do nothing.

        return ans