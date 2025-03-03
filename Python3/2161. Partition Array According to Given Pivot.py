class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        ans = []
        pivot_count = 0
        for n in nums:
            if n < pivot:
                ans.append(n)
            elif n == pivot:
                pivot_count += 1

        ans.extend([pivot] * pivot_count)
        for n in nums:
            if n > pivot:
                ans.append(n)
        return ans