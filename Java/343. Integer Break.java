class Solution {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        
        int multi = n/3;
        int rem = n%3;
        if (rem == 0) {
            return (int)Math.pow(3, multi);
        } else if (rem == 1) {
            return (int)Math.pow(3, multi-1) * 4;
        }
        return (int)Math.pow(3, multi) * 2;
    }
}