class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> sub = new HashMap();
        int ans = 0, m, time;
        
        for (int i=0; i<manager.length; i++) {
            m = manager[i];
            if (m != -1) {
                if (!sub.containsKey(m)) {
                    sub.put(m, new ArrayList<>());
                } 
                sub.get(m).add(i);
            }
        }
        
        Queue<int[]> q = new LinkedList();
        q.offer(new int[] {headID, 0});
        
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            time = informTime[temp[0]] + temp[1];
            if (sub.containsKey(temp[0])) {
                for (int p: sub.get(temp[0])) {
                    q.offer(new int[] {p, time});
                }
            }
            
            ans = Math.max(ans, time);
        }
        
        return ans;
    }
}