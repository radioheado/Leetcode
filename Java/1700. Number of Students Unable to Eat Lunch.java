class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ones = 0, zero = 0;
        for (int s: students) {
            if (s == 0) {
                zero++;
            } else {
                ones++;
            }
        }

        for (int s: sandwiches) {
            // current sandwitch is 0 but no students want it
            if (s == 0 && zero == 0) {
                return ones;
            }

            // current sandwitch is 1 but no students want it
            if (s == 1 && ones == 0) {
                return zero;
            }

            if (s == 0) {
                zero--;
            } else {
                ones--;
            }
        }

        return 0;
    }
}