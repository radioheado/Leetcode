class Solution {
    public int countPoints(String rings) {
        int[][] rods = new int[10][3];
        for (int i=0; i<rings.length(); i+=2) {
            if (rings.charAt(i) == 'R') {
                rods[Character.getNumericValue(rings.charAt(i+1))][0] = 1;
            } else if (rings.charAt(i) == 'G') {
                rods[Character.getNumericValue(rings.charAt(i+1))][1] = 1;
            } else {
                rods[Character.getNumericValue(rings.charAt(i+1))][2] = 1;
            }
        }

        int ans = 0;
        for (int[] r: rods) {
            if (r[0] + r[1] + r[2] == 3) {
                ans++;
            }
        }

        return ans;
    }
}