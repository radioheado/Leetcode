class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 1;
        
        // find max pile
        for(int p: piles){
            high = Math.max(high, p);
        }
        
        while(low < high){
            int mid = (high-low)/2 + low;
            int hours = 0;
            
            for(int p: piles){
                hours += Math.ceil((double) p/mid);
                if(hours > h){
                    break;
                }
            }
            
            if(hours > h){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        
        return low;
    }
}