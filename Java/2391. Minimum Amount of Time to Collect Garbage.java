class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        boolean G = false, P = false, M = false;

        for (int i = travel.length; i > 0; i--) {
            String g = garbage[i];
            ans += g.length();
            G |= g.indexOf('G') != -1;
            P |= g.indexOf('P') != -1;
            M |= g.indexOf('M') != -1;
            
            if (G) {
                ans += travel[i-1];
            }
            if (P) {
                ans += travel[i-1];
            }
            if (M) {
                ans += travel[i-1];
            }
        }

        return ans + garbage[0].length();
    }
}