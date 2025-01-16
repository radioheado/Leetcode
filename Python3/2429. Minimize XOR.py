class Solution:
    def minimizeXor(self, num1: int, num2: int) -> int:
        set_count = bin(num1).count('1')
        target_count = bin(num2).count('1')

        ans = num1
        current_bit = 0

        # Case 1: Add bits to ans if num2 has more 1s
        while set_count < target_count:
            # If the current bit in result is 0, set it to 1
            if not ans & (1 << current_bit):
                ans |= (1 << current_bit)
                set_count += 1

            current_bit += 1

        # Case 2: Remove bits to ans if num1 has more 1s
        while set_count > target_count:
            # If the current bit in result is 1, unset it to 0
            if ans & (1 << current_bit):
                ans &= ~(1 << current_bit)
                set_count -= 1

            current_bit += 1

        return ans