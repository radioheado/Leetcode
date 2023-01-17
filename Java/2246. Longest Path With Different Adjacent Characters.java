class Solution {
    private int ans = 1;

    public int longestPath(int[] parent, String s) {
        Map<Integer, List<Integer>> children = new HashMap();
        for (int i=1; i<parent.length; i++) {
            children.computeIfAbsent(parent[i], value -> new ArrayList<Integer>()).add(i);
        }
        dfs(0, children, s);
        return ans;
    }

    private int dfs(int node, Map<Integer, List<Integer>> children, String s) {
        if (!children.containsKey(node)) {
            return 1;
        }

        int longest = 0, second = 0;
        for (int child: children.get(node)) {
            int childPath = dfs(child, children, s);
            if (s.charAt(child) == s.charAt(node)) {
                continue;
            }

            if (childPath > longest) {
                second = longest;
                longest = childPath;
            } else if (childPath > second) {
                second = childPath;
            }
        }

        ans = Math.max(ans, longest + second + 1);
        return longest + 1;
    }
}