class Solution {
    public int mySqrt(int x) {
        long low = 0, high = x, mid;
        mid = (low+high)/2;
        
        while(low < high){
            
            if(mid*mid == x){
                //System.out.println("found = "+ low + ", " + mid + ", " + high);
                return (int) mid;
            }
            
            if(mid*mid > x){
                high = mid - 1;
                //System.out.println("high = "+ low + ", " + mid + ", " + high);
            }else{
                low = mid + 1;
                //System.out.println("low = "+ low + ", " + mid + ", " + high);
            }
            
            mid = (low+high)/2;
        }
        
        int ans = (int) mid;
        
        return (ans*ans > x) ? (ans-1) : ans;
        
        
    }
}