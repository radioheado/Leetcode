class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet();

        if (bound == 0) {
            return new ArrayList(ans);
        }

        int xbound = x == 1 ? bound : (int) (Math.log(bound) / Math.log(x));
        int ybound = y == 1 ? bound : (int) (Math.log(bound) / Math.log(y));

        for (int i=0; i<=xbound; i++) {
            for (int j=0; j<=ybound; j++) {
                int val = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (val <= bound) {
                    ans.add(val);
                }
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }

        return new ArrayList(ans);
    }
}