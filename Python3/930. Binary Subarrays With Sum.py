class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        prefix = collections.defaultdict(int)
        psum = ans = 0

        for n in nums:
            psum += n
            if psum == goal:
                ans += 1

            if psum - goal in prefix:
                ans += prefix[psum - goal]

            prefix[psum] += 1

        return ans