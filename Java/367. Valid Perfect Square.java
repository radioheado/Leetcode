class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        
        while(left <= right){
            long mid = (right-left)/2 + left;
            long square = mid*mid;
            
            if(square == num){
                return true;
            }else if(square < num){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return false;
    }
}