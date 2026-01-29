class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        count = 0

        while len(nums) > 1:
            is_valid = True
            min_sum = float(inf)
            index = -1

            for i in range(len(nums) - 1):
                _sum = nums[i] + nums[i + 1]
                if nums[i] > nums[i + 1]:
                    is_valid = False

                if _sum < min_sum:
                    min_sum = _sum
                    index = i

            if is_valid:
                break

            count += 1
            nums[index] = min_sum
            nums.pop(index + 1)

        return count