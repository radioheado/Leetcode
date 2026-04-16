class Solution:
    def solveQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        indices = defaultdict(list)
        for i, n in enumerate(nums):
            indices[n].append(i)

        for i, query in enumerate(queries):
            num = nums[query]
            if len(indices[num]) < 2:
                queries[i] = -1
                continue

            idx = bisect_left(indices[num], query)
            offset = len(nums) - indices[num][-1] + indices[num][0]

            left = offset if idx == 0 else indices[num][idx] - indices[num][idx - 1]
            right = offset if idx == len(indices[num]) - 1 else indices[num][idx + 1] - indices[num][idx]

            queries[i] = min(left, right)

        return queries