class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue();
        long sum = 0;
        for (int g: gifts) {
            heap.add(-g);
            sum += g;
        }

        for (int i = 0; i < k; i++) {
            int cur = -heap.poll();
            int root = (int) Math.sqrt(cur);

            heap.add(-root);
            sum -= cur - root;
        }

        return sum;
    }
}