class Solution:
    def check(self, nums: List[int]) -> bool:
        head = False

        for i, n in enumerate(nums[1:], 1):
            if nums[i - 1] > n:
                if not head:
                    head = True
                else:
                    return False

        return nums[0] >= nums[-1] if head else True