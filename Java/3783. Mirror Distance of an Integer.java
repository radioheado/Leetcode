class Solution {
    public int mirrorDistance(int n) {
        int num = 0, copy = n;
        while (n > 0) {
            num = num * 10 + n % 10;
            n /= 10;
        }
        return Math.abs(copy - num);
    }
}