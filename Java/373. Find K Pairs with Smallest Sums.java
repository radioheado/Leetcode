class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        List<List<Integer>> ans = new ArrayList();
        Set<Pair<Integer, Integer>> visited = new HashSet();
        heap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add(new Pair<Integer, Integer>(0, 0));
        int m = nums1.length, n = nums2.length;

        while (k-- > 0 && !heap.isEmpty()) {
            int[] cur = heap.poll();
            int i = cur[1], j = cur[2];
            ans.add(List.of(nums1[i], nums2[j]));

            if (i+1 < m && !visited.contains(new Pair<Integer, Integer>(i+1, j))) {
                heap.offer(new int[]{nums1[i+1] + nums2[j], i+1, j});
                visited.add(new Pair<Integer, Integer>(i+1, j));
            }

            if (j+1 < n && !visited.contains(new Pair<Integer, Integer>(i, j+1))) {
                heap.offer(new int[]{nums1[i] + nums2[j+1], i, j+1});
                visited.add(new Pair<Integer, Integer>(i, j+1));
            }
        }

        return ans;
    }
}