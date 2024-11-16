class Solution {
    public int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> flavors = new HashMap<>();
        for (int c: candies) {
            flavors.put(c, flavors.getOrDefault(c, 0) + 1);
        }
        
        // Special case
        if (k == 0) {
            return flavors.size();
        }

        int total_flavors = flavors.size(), ans = 0;
        for (int i = 0; i < candies.length; i++) {
            flavors.put(candies[i], flavors.get(candies[i]) - 1);
            if (flavors.get(candies[i]) == 0) {
                total_flavors--;
            }
            if (i >= k - 1) {
                ans = Math.max(ans, total_flavors);
                flavors.put(candies[i - k + 1], flavors.get(candies[i - k + 1]) + 1);
                if (flavors.get(candies[i - k + 1]) == 1) {
                    total_flavors++;
                }
            }
        }
        return ans;
    }
}