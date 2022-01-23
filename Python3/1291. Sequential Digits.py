class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        window = '123456789'
        nums = []
        
        for l in range(len(str(low)), len(str(high))+1):
            for start in range(10 - l):
                num = int(window[start: start+l])
                if low <= num <= high:
                    nums.append(num)
                    
        return nums