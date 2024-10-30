class Solution:
    def minimumMountainRemovals(self, nums: List[int]) -> int:
        
        def longestIncreasing(reverse = False) -> List[int]:
            ans = [1]

            if not reverse:
                sub = [nums[0]]
                L = 1
                for n in nums[1:]:
                    i = bisect_left(sub, n)
                    if i == L:
                        sub.append(n)
                        L += 1
                    else:
                        sub[i] = n
                    ans.append(L)
            else:
                sub = [nums[-1]]
                L = 1
                for n in reversed(nums[:-1]):
                    i = bisect_left(sub, n)
                    if i == L:
                        sub.append(n)
                        L += 1
                    else:
                        sub[i] = n
                    ans.append(L)
                ans.reverse()
            return ans

        left_to_right = longestIncreasing()
        right_to_left = longestIncreasing(True)

        N = len(nums)
        ans = N
        for i, n in enumerate(nums):
            # Check if it makes a valid peak
            if left_to_right[i] > 1 and right_to_left[i] > 1:
                ans = min(ans, N + 1 - left_to_right[i] - right_to_left[i])

        return ans