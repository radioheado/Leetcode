class Solution {

    private static int[] punishment = new int[1001];

    static {
        for (int i = 1; i < 1001; i++) {
            if (canPartition(i * i, i)) {
                punishment[i] += punishment[i - 1] + i * i;
            } else {
                punishment[i] = punishment[i - 1];
            }
        }
    }

    private static boolean canPartition(int cur, int target) {
        if (target < 0 || cur < target) {
            return false;
        }

        if (cur == target) {
            return true;
        }

        return (canPartition(cur / 10, target - cur % 10) || 
                canPartition(cur / 100, target - cur % 100) || 
                canPartition(cur / 1000, target - cur % 1000)
                );
    }
    
    public int punishmentNumber(int n) {
        return punishment[n];
    }
}