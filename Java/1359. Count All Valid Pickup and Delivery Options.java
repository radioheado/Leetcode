class Solution {
    public int countOrders(int n) {
        long ans = 1;
        double mod = Math.pow(10, 9) + 7;
        for(int i=1; i<=n; i++) {
            ans *= i;
            ans *= (2*i-1);
            ans %= mod;
        }
        return (int) ans;
    }
}