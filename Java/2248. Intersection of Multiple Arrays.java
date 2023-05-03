class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        for (int[] num: nums) {
            for (int n: num) {
                count[n]++;
            }
        }

        int N = nums.length;
        List<Integer> ans = new ArrayList();
        for (int i = 1; i < 1001; i++) {
            if (count[i] == N) {
                ans.add(i);
            }
        }

        return ans;
    }
}