class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        arr.sort()
        min_diff = inf
        ans = []

        for i, n in enumerate(arr[1:], 1):
            cur_diff = n - arr[i - 1]
            if cur_diff == min_diff:
                ans.append([arr[i - 1], n])
            elif cur_diff < min_diff:
                ans = [[arr[i - 1], n]]
                min_diff = cur_diff

        return ans