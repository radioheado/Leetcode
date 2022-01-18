class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = -1, cur = 0;
        
        while(cur < flowerbed.length){
            if(flowerbed[cur] == 1){
                if(prev == -1){
                    n -= cur/2;
                }else{
                    n -= ((cur-prev)/2 - 1);
                }
                
                prev = cur;
                if(n <= 0){
                    return true;
                }
            }
            cur++;
        }
        
        if(flowerbed[cur-1] == 0){
            if(prev == -1)
                n -= (cur+1)/2;
            else
                n -= ((cur-prev+1)/2-1);
        }
            
        return n <= 0 ? true : false;
    }
}