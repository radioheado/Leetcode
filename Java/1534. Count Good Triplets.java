class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0, N = arr.length;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && 
                        Math.abs(arr[j] - arr[k]) <= b && 
                        Math.abs(arr[i] - arr[k]) <= c) {
                            ans++;
                        }
                }
            }
        }

        return ans;
    }
}