class Bucket:
    def __init__(self):
        self.taken = False
        self.minval = inf
        self.maxval = -inf

class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 0

        mmin, mmax = min(nums), max(nums)
        bucket_size = max(1, (mmax - mmin) // (len(nums) - 1))
        bucket_num = (mmax - mmin) // bucket_size + 1
        buckets = [Bucket() for _ in range(bucket_num)]

        for n in nums:
            i = (n - mmin) // bucket_size
            buckets[i].taken = True
            buckets[i].minval = min(n, buckets[i].minval)
            buckets[i].maxval = max(n, buckets[i].maxval)

        pre_max = mmin
        ans = 0
        for bucket in buckets:
            if not bucket.taken:
                continue

            ans = max(ans, bucket.minval - pre_max)
            pre_max = bucket.maxval

        return ans