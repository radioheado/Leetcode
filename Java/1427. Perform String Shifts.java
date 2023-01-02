class Solution {
    public String stringShift(String s, int[][] shift) {
        int S = s.length(), shifts = 0;

        for (int[] ss: shift) {
            if (ss[0] == 1) {
                ss[1] *= -1;
            }
            shifts += ss[1];
        }

        shifts = Math.floorMod(shifts, S);
        s = s.substring(shifts) + s.substring(0, shifts);
        return s;
    }
}