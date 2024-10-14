class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int n: nums) {
            heap.add(n);
        }

        while (!heap.isEmpty() && k > 0) {
            int highest = heap.poll();
            k--;
            score += highest;
            heap.add((int) Math.ceil(highest / 3.0));
        }

        return score;
    }
}