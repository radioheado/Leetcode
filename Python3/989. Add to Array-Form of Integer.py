class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        carry = 0
        
        for i in range(len(num)-1, -1, -1):
            x = num[i]
            y = k % 10
            carry, rem = divmod(x+y+carry, 10)
            num[i] = rem
            k //= 10
        
        while carry or k:
            x = k % 10
            carry, rem = divmod(x+carry, 10)
            num.insert(0, rem)
            k //= 10
            
        return num