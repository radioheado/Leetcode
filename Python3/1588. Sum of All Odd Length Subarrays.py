class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        total = N = ans = 0
        for i, n in enumerate(arr):
            total += n
            N += 1
            arr[i] = total
        
        for i in range(N):
            for j in range(i, N):
                if (j-i) % 2 == 0:
                    ans += arr[j] - arr[i-1] if i > 0 else arr[j]
            
        return ans