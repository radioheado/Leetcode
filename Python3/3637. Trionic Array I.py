class Solution:
    def isTrionic(self, nums: List[int]) -> bool:
        first = second = third = False
        ptr = 0

        while ptr < len(nums) - 1:
            if nums[ptr] < nums[ptr + 1]:
                first = True
            else:
                break
            ptr += 1

        while ptr < len(nums) - 1:
            if nums[ptr] > nums[ptr + 1]:
                second = True
            else:
                break
            ptr += 1

        while ptr < len(nums) - 1:
            if nums[ptr] < nums[ptr + 1]:
                third = True
            else:
                break
            ptr += 1

        return ptr == len(nums) - 1 and first and second and third