class Solution {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int n: arr) {
            count[n]++;
        }

        int num = -1;
        for (int i = 1; i <= 500; i++) {
            if (i == count[i]) {
                num = Math.max(num, i);
            }
        }
        return num;
    }
}