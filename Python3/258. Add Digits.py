class Solution:
    def addDigits(self, num: int) -> int:
        while num > 9:
            temp = 0
            for d in str(num):
                temp += int(d)
            num = temp
            
        return num