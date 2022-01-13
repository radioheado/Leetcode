class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 1){
            return 1;
        }
        
        Arrays.sort(points, (o1, o2) ->{
            /* we can't use o1[1] - o2[1] trick directly
             * as this will cause an integer overflow
             */
            if(o1[1] == o2[1]){
                return 0;
            }
            if(o1[1] < o2[1]){
                return -1;
            }
            return 1;
        });
            
        int prev = points[0][1];
        int shots = 1;
        for(int i=1; i<points.length; i++){
            int[] cur = points[i];
            if(prev < cur[0]){
                shots++;
                prev = cur[1];
            }
        }
        
        return shots;
    }
}