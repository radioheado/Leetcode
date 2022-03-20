class Solution {
    public int findNumberOfLIS(int[] nums) {
        int L = nums.length;
        int[] dpl = new int[L];
        Arrays.fill(dpl, 1);
        int[] dpw = new int[L];
        Arrays.fill(dpw, 1);
        int max = 1;
        
        for (int i=1; i<L; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    if (dpl[i] < dpl[j]+1) {
                        dpl[i] = dpl[j]+1;
                        dpw[i] = dpw[j];
                    } else if (dpl[i] == dpl[j]+1) {
                        dpw[i] += dpw[j];
                    }
                }
            }
            max = Math.max(max, dpl[i]);
        }
        
        int ans = 0;
        for (int i=0; i<L; i++) {
            if (dpl[i] == max) {
                ans += dpw[i];
            }
        }
        
        return ans;
    }
}