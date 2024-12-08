class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        times = []
        for s, e, v in events:
            times.append((s, 1, v))
            times.append((e + 1, 0, v))

        ans = max_val = 0
        times.sort()

        for t, is_start, v in times:
            # If it's a start time, update ans with a previously ended value
            if is_start:
                ans = max(ans, v + max_val)
            # If it's an ent time, update max_val if this is bigger than the previous one
            else:
                max_val = max(max_val, v)

        return ans