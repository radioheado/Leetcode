class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int[] sea = new int[101];
        int[] stu = new int[101];

        for (int s: seats) {
            sea[s]++;
        }
        for (int s: students) {
            stu[s]++;
        }

        int ans = 0, j = 0;
        for (int i = 0; i < 101; i++) {
            int seat = 0;
            while (seat < sea[i]) {
                while(stu[j] == 0) {
                    j++;
                }
                seat++;
                stu[j]--;
                ans += Math.abs(j - i);
            }
        }

        return ans;
    }
}