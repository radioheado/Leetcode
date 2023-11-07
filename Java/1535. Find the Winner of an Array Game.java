class Solution {
    public int getWinner(int[] arr, int k) {
        int cur = arr[0], count = 0;

        for (int i = 1; i < arr.length; i++) {
            if (cur > arr[i]) {
                count++;
            } else {
                cur = arr[i];
                count = 1;
            }
            if (count == k) {
                return cur;
            }
        }

        return cur;
    }
}