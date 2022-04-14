class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> dis = new HashMap<>();
        int d;
        
        for (int i=0; i<points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                d = Math.abs(points[i][0] - x + points[i][1] - y);
                if (!dis.containsKey(d)) {
                    dis.put(d, i);
                    min = Math.min(min, d);
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : dis.get(min);
    }
}