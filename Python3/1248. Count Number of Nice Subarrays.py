class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        count = collections.defaultdict(int)
        count[0] = 1
        ans = odds = 0

        for n in nums:
            if n % 2 == 1:
                odds += 1

            if odds - k in count:
                ans += count[odds - k]

            count[odds] += 1
        
        return ans