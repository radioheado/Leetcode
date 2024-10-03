class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> nums = new TreeSet<>();
        for (int n: arr) {
            nums.add(n);
        }

        int rank = 1;
        for (int n: nums) {
            map.put(n, rank++);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}