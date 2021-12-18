class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 1
        
        for i in range(-1, -len(digits)-1, -1):
            # get the carry and the current digit
            carry, digit = divmod(carry + digits[i], 10)
            
            # update the current index in digits
            digits[i] = digit
            
            # if there is no carry, stop here
            if carry == 0:
                break
            
            
        # check if there's a carry to add at the beginning of the digits array
        if carry:
            digits.insert(0, carry)
            
        return digits