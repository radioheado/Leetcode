class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> leaves = new PriorityQueue<>();
        for (int[] i: intervals) {
            if (!leaves.isEmpty() && leaves.peek() < i[0]) {
                leaves.poll();
            }
            leaves.add(i[1]);
        }
        return leaves.size();
    }
}