class Solution:
    def countInterestingSubarrays(self, nums: List[int], modulo: int, k: int) -> int:
        prefix = Counter([0])
        ans = count = 0

        for n in nums:
            count += n % modulo == k
            ans += prefix[(count - k + modulo) % modulo]
            prefix[count % modulo] += 1

        return ans