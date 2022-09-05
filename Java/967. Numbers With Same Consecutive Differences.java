class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> q = new LinkedList();
        for (int i=1; i<10; i++) {
            q.offer(i);
        }
        
        int size, cur, last;
        for (int i=1; i<n; i++) {
            size = q.size();
            for (int j=0; j<size; j++) {
                cur = q.poll();
                last = cur % 10;
                if (last + k < 10) {
                    q.offer(cur * 10 + last + k);
                }
                if (k != 0 && last - k >= 0) {
                    q.offer(cur * 10 + last - k);
                }
            }
        }
        return q.stream().mapToInt(i -> i).toArray();
    }
}