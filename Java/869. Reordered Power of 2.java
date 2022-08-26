class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] digits = count(n);
        int power = 0, num = 1, L = length(n), N;
        
        while (power < 30) {
            N = length(num);
            /* only check the digits when the two nums have the same length*/
            if (L == N) {
                if (Arrays.equals(digits, count(num))) {
                    return true;
                }
            }
            else if (L < N) {
                return false;
            }
            power++;
            num *= 2;
        }
        
        return false;
    }
    
    /* a helper function to count digits in a number*/
    private int[] count(int n) {
        int[] ans = new int[10];
        while (n > 0) {
            ans[n % 10]++;
            n /= 10;
        }
        return ans;
    }
    
    /* a helper fcuntion to calculate the length of a number*/
    private int length(int n) {
        int ans = 0;
        while (n > 0) {
            ans++;
            n /= 10;
        }
        return ans;
    }
}