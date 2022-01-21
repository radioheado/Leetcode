class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        
        // calculate all edges
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                edges.add(new Edge(i, j, distance(points[i], points[j])));
            }
        }
        
        
        // sort all edges according to its distance
        Collections.sort(edges, (cur, other) -> cur.cost-other.cost);
        
        DSU dsu = new DSU(points.length);
        int total = 0;
        
        // loop the sorted edges
        for(Edge edge: edges){
            int u = edge.point1, v = edge.point2, c = edge.cost;
            if(!dsu.connected(u, v)){
                dsu.union(u, v);
                total += c;
            }
        }
        
        return total;
        
    }
    
    private int distance(int[] point1, int[] point2){
        int x1 = point1[0], y1 = point1[1];
        int x2 = point2[0], y2 = point2[1];
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }
}


class Edge{
    int point1;
    int point2;
    int cost;
    
    Edge(int point1, int point2, int cost){
        this.point1 = point1;
        this.point2 = point2;
        this.cost = cost;
    }
}


class DSU{
    private int[] root;
    private int[] rank;
    
    DSU(int size){
        root = new int[size];
        rank = new int[size];
        
        for(int i=0; i<size; i++){
            root[i] = i;
            rank[i] = 0;
        }
    }
    
    public int find(int x){
        return (x == root[x]) ? x : (root[x] = find(root[x]));
    }
    
    public void union(int x, int y){
        int rx = find(x), ry = find(y);
        
        if(rx != ry){
            if(rank[rx] < rank[ry]){
                root[rx] = ry;
            }else if(rank[rx] > rank[ry]){
                root[ry] = rx;
            }else{
                root[rx] = ry;
                rank[ry]++;
            }
        }
    }
    
    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}