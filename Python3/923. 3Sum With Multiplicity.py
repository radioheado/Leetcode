class Solution:
    def threeSumMulti(self, arr: List[int], target: int) -> int:
        count = Counter(arr)
        ans = 0
        nums = sorted(count)
        modulo = 10**9 + 7
        
        for i, n in enumerate(nums):
            T = target - n
            j, k = i, len(nums)-1
            while j <= k:
                c1, c2 = nums[j], nums[k]
                if c1 + c2 < T:
                    j += 1
                elif c1 + c2 > T:
                    k -= 1
                else:
                    if i < j < k:
                        ans += count[n] * count[c1] * count[c2]
                    elif i == j < k:
                        ans += count[n] * (count[n] - 1) // 2 * count[c2]
                    elif i < j == k:
                        ans += count[n] * count[c1] * (count[c1] - 1) // 2
                    else:
                        ans += count[n] * (count[n] - 1) * (count[n] - 2) // 6
                    j += 1
                    k -= 1
        
        return ans % modulo
                
            