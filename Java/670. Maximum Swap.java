class Solution {
    public int maximumSwap(int num) {
        char[] nums = Integer.toString(num).toCharArray();
        
        //System.out.println(nums);
        
        for(int i=0; i<nums.length; i++){
            int index = restMax(nums, i);
            if(index != i){
                char copy = nums[i];
                nums[i] = nums[index];
                nums[index] = copy;
                break;
            }
        }
        
        int res = 0;
        
        for(char n: nums){
            res = res*10 + Integer.parseInt(String.valueOf(n));
        }
        
        return res;
    }
    
    private int restMax(char[] nums, int cur){
        int max = cur;
        
        for(int i=cur+1; i<nums.length; i++){
            int m = Integer.parseInt(String.valueOf(nums[max]));
            int c = Integer.parseInt(String.valueOf(nums[i]));
            
            if(c >= m){
                max = i;
            }
        }
        
        int m = Integer.parseInt(String.valueOf(nums[max]));
        int c = Integer.parseInt(String.valueOf(nums[cur]));
        
        if(m == c){
            return cur;
        }else{
            return max;
        }
        
    }
}