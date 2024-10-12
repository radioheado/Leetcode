class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        leaves = []

        for s, e in intervals:
            # A team leaves before the current team starts
            if leaves and leaves[0] < s:
                heappop(leaves)
            heappush(leaves, e)

        return len(leaves)