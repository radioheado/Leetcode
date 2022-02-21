class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int types = 0;
        int left = 0, ans = 0;
        
        for(int i=0; i<fruits.length; i++) {
            // about to add a new fruit
            if(basket.getOrDefault(fruits[i], 0) == 0) {
                basket.put(fruits[i], 0);
                types++;
            }
            
            basket.put(fruits[i], basket.get(fruits[i])+1);
            
            while(types > 2) {
                basket.put(fruits[left], basket.get(fruits[left])-1);
                if(basket.get(fruits[left]) == 0) {
                    types--;
                }
                left++;
            }
            
            ans = Math.max(ans, i-left+1);
        }
        return ans;
    }
}