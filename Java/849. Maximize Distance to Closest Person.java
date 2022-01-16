class Solution {
    public int maxDistToClosest(int[] seats) {
        int left = -1, right = 0, dis = 0;
        
        while(right < seats.length){
            if(seats[right] == 1){
                if(left == -1){
                    dis = right;
                }else{
                    dis = Math.max(dis, (right-left)/2);
                }
                left = right;
            }
            right++;
        }
        
        if(seats[right-1] == 0){
            dis = Math.max(dis, (right-left-1));
        }else{
            dis = Math.max(dis, (right-left)/2);
        }
        
        return dis;
    }
}