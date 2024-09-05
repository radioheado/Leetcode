class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        m = len(rolls)
        total = (m + n) * mean - sum(rolls)

        # Unable to construct the array
        if total < n or total > 6 * n:
            return []

        new_mean, mod = divmod(total, n)
        return [new_mean] * (n - mod) + [new_mean + 1] * mod