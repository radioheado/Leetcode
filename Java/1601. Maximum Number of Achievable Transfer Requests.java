class Solution {
    private int ans;

    public int maximumRequests(int n, int[][] requests) {
        ans = 0;
        backtrack(n, requests, new int[n], 0, 0);
        return ans;
    }

    private void backtrack(int n, int[][] requests, int[] indegree, int start, int count) {
        if (start == requests.length) {
            for (int i = 0; i < n; i++) {
                if (indegree[i] != 0) {
                    return;
                }
            }
            ans = Math.max(ans, count);
            return;
        }
        indegree[requests[start][0]]--;
        indegree[requests[start][1]]++;
        // accept this request
        backtrack(n, requests, indegree, start + 1, count + 1);
        indegree[requests[start][0]]++;
        indegree[requests[start][1]]--;

        // ignore this request
        backtrack(n, requests, indegree, start + 1, count);
    }
}