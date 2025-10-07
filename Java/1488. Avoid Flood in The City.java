class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);;
        TreeSet<Integer> no_rain_days = new TreeSet<>();
        Map<Integer, Integer> full = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (lake == 0) {
                no_rain_days.add(i);
                continue;
            } 

            ans[i] = -1;
            if (full.containsKey(lake)) {
                Integer p = no_rain_days.ceiling(full.get(lake));
                if (p == null) {
                    return new int[0];
                }
                ans[p] = lake;
                no_rain_days.remove(p);
            }
            full.put(lake, i);
        }

        return ans;
    }
}