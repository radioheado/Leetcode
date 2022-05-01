class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        
        if (rows == 1 && cols == 1) return 0;
        
        int diff;
        DSU dsu = new DSU(rows*cols);
        List<Edge> edges = new ArrayList<>();
        
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (r > 0) {
                    diff = Math.abs(heights[r][c] - heights[r-1][c]);
                    edges.add(new Edge(r*cols+c, (r-1)*cols+c, diff));
                } 
                
                if (c > 0) {
                    diff = Math.abs(heights[r][c] - heights[r][c-1]);
                    edges.add(new Edge(r*cols+c, r*cols+c-1, diff));
                }
            }
        }
        
        /* sort the edges by their diffs */
        Collections.sort(edges, (e1, e2) -> e1.diff - e2.diff);
        
        for (int i=0; i<edges.size(); i++) {
            int x = edges.get(i).x, y = edges.get(i).y; 
            diff = edges.get(i).diff;
            dsu.union(x, y);
            if (dsu.connected()) return diff;
        }
        return -1;
    }
} 


class Edge {
    int x, y, diff;
    
    Edge(int x, int y, int diff) {
        this.x = x;
        this.y = y;
        this.diff = diff;
    }
}

class DSU {
    int[] root;
    int[] rank;
    
    DSU (int size) {
        root = new int[size];
        rank = new int[size];
        
        for (int i=0; i<size; i++) {
            root[i] = i;
            rank[i] = 0;
        }
    }
    
    public int find(int x) {
        return root[x] == x ? x : (root[x] = find(root[x]));
    }
    
    public void union(int x, int y) {
        int rootx = find(x), rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                root[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                root[rootx] = rooty;
            } else{
                root[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }
    
    public boolean connected() {
        return find(0) == find(root.length-1);
    }
}