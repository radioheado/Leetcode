class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reachable = new boolean[numCourses][numCourses];

        for (int[] edge: prerequisites) {
            reachable[edge[0]][edge[1]] = true;
        }

        for (int imd = 0; imd < numCourses; imd++) {
            for (int src = 0; src < numCourses; src++) {
                for (int tgt = 0; tgt < numCourses; tgt++) {
                    reachable[src][tgt] = reachable[src][tgt] ||
                        (reachable[src][imd] && reachable[imd][tgt]);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] query: queries) {
            ans.add(reachable[query[0]][query[1]]);
        }

        return ans;
    }
}