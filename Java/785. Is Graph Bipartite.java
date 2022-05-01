class Solution {
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] color = new int[size];
        Arrays.fill(color, -1);
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<size; i++) {
            if (color[i] == -1) {
                stack.push(i);
                color[i] = 0;
                
                while (!stack.isEmpty()) {
                    Integer node = stack.pop();
                    for (int nei: graph[node]) {
                        if (color[nei] == -1) {
                            color[nei] = color[node] ^ 1;
                            stack.push(nei);
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}