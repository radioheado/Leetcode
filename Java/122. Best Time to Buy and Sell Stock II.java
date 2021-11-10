class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = 0;
        int ans = 0;
        
        for(int i=1; i<prices.length; i++){
            if(prices[i] >= prices[i-1]){
                max = i;
            }else{
                if(max > min){
                    ans += prices[max]-prices[min];
                }
                min = i;
                
            }
        }
        
        if(max > min){
            ans += prices[max]-prices[min];
        }
        
        return ans;
        
    }
}