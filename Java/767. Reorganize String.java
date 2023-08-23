class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer(new int[] {i + 'a', count[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            sb.append((char)top[0]);

            // only one char left, finish here
            if (pq.isEmpty() && top[1] == 1) {
                break;
            } 
            // more than one char left
            else if (!pq.isEmpty()) {
                int[] sec = pq.poll();
                sb.append((char)sec[0]);
                if (top[1] > 1) {
                    pq.offer(new int[] {top[0], top[1] - 1});
                }
                if (sec[1] > 1) {
                    pq.offer(new int[] {sec[0], sec[1] - 1});
                }
            }
            else {
                return new String();
            }
        }

        return sb.toString();
    }
}