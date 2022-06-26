class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int total = 0, ans = 0, N = arr.length;
        for (int i=0; i<N; i++) {
            total += arr[i];
            arr[i] = total;
        }
        
        for (int i=0; i<N; i++) {
            for (int j=i; j<N; j++) {
                if ((j-i) % 2 == 0) {
                    ans += i == 0 ? arr[j] : arr[j] - arr[i-1];
                }
            }
        }
        
        return ans;
    }
}