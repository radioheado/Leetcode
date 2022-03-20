class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, int[]> nums = new HashMap<>();
        for (int n=1; n<7; n++) {
            nums.put(n, new int[] {0, 0, 0});
        }
        
        int N = tops.length;
        for (int i=0; i<N; i++) {
            int n1 = tops[i], n2 = bottoms[i];
            if (n1 == n2) {
                nums.get(n1)[0]++;
                nums.get(n1)[1]++;
                nums.get(n1)[2]++;
            } else {
                nums.get(n1)[0]++;
                nums.get(n1)[1]++;
                nums.get(n2)[0]++;
                nums.get(n2)[2]++;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int[] cur: nums.values()) {
            if (cur[0] < N) {
                continue;
            }
            ans = Math.min(ans, Math.min(N-cur[1], N-cur[2]));
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}