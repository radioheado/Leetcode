class Solution:
    def smallestSubarrays(self, nums: List[int]) -> List[int]:
        N = len(nums)
        pos = [-1] * 31
        ans = [0] * N

        for i in range(N - 1, -1, -1):
            j = i
            for bit in range(31):
                if (nums[i] & (1 << bit)) == 0:
                    # If this bit is 0 and there's a num in the right hand side
                    # Then the max for the i-th num need to include the j-th num
                    if pos[bit] != -1:
                        j = max(j, pos[bit])
                else:
                    # Update the nearest num that sets this bit to 1
                    pos[bit] = i

            ans[i] = j - i + 1

        return ans