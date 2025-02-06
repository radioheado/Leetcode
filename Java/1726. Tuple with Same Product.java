class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> products = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int n2 = nums[j];
                products.put(n1 * n2, products.getOrDefault(n1 * n2, 0) + 1);
            }
        }

        int ans = 0;
        for (int v: products.values()) {
            ans += 4 * v * (v - 1);
        }

        return ans;
    }
}