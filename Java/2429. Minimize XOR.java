class Solution {
    public int minimizeXor(int num1, int num2) {
        int ans = num1, current_bit = 0;
        int target_count = Integer.bitCount(num2);
        int set_count = Integer.bitCount(num1);

        while (set_count < target_count) {
            if (!isSet(ans, current_bit)) {
                ans = setBit(ans, current_bit);
                set_count++;
            }
            current_bit++;
        }

        while (set_count > target_count) {
            if (isSet(ans, current_bit)) {
                ans = unsetBit(ans, current_bit);
                set_count--;
            }
            current_bit++;
        }

        return ans;
    }

    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    private int setBit(int x, int bit) {
        return x | (1 << bit);
    }

    private int unsetBit(int x, int bit) {
        return x & ~(1 << bit);
    }
}