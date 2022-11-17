class Solution {
    /** 
     * 0: not visited
     * 1: under investigation
     * 2: completed investigation
     */
    private int[] status;
    private Map<Integer, List<Integer>> adjs;
    private boolean hasCycle = false;
    private List<Integer> order;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        status = new int[numCourses];
        /* initially, all courses are unvisited: 0 */
        Arrays.fill(status, 0);
        
        adjs = new HashMap();
        for (int[] preq: prerequisites) {
            int cur = preq[0], pre = preq[1];
            adjs.putIfAbsent(pre, new ArrayList<Integer>());
            adjs.get(pre).add(cur);
        }
        
        order = new ArrayList();
        
        for (int c=0; c<numCourses; c++) {
            if (status[c] == 0) {
                dfs(c);
            }
        }
        
        if (hasCycle || order.size() != numCourses) {
            return new int[0];
        }
        
        int i = numCourses - 1;
        for (int c: order) {
            status[i--] = c;
        }
        
        return status;
    }
    
    private void dfs(int course) {
        if (hasCycle) {
            return;
        }
        
        status[course] = 1;
        if (adjs.containsKey(course)) {
            /* get the next courses */
            for (int next: adjs.get(course)) {
                /* next course is visitable */
                if (status[next] == 0) {
                    dfs(next);
                }
                /* cycle detected */
                else if (status[next] == 1) {
                    hasCycle = true;
                }
            }
        }  
        
        status[course] = 2;
        order.add(course);
    }
}