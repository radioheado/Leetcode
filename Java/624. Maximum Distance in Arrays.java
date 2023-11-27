class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0, n = arrays.size(), first = arrays.get(0).size();
        int min = arrays.get(0).get(0), max = arrays.get(0).get(first - 1);

        for (int i = 1; i < n; i++) {
            List<Integer> array = arrays.get(i);
            int cur_min = array.get(0), cur_max = array.get(array.size() - 1);
            ans = Math.max(ans, Math.max(Math.abs(cur_max - min), Math.abs(max - cur_min)));
            min = Math.min(cur_min, min);
            max = Math.max(cur_max, max);
        }

        return ans;
    }
}