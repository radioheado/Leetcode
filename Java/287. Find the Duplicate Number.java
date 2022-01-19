class Solution {
    public int findDuplicate(int[] nums) {
        /* for a dup num, the number less or equal than it is greater than itself
         * e.g. nums -> [1,2,2,3], count -> [1,3,3,4]
         *      if num < count:  the dup num is equal or smaller than current num
         *      otherwise, the dup num is greater than current num
         */
        
        int left = 0, right = nums.length-1;
        int dup = 0;
        
        while(left <= right){
            int cur = (right-left)/2 + left;
            int count = 0;
            
            for(int num: nums){
                if(num <= cur){
                    count++;
                }
            }
            
            if(cur < count){
                dup = cur;
                right = cur-1;
            }else{
                left = cur+1;
            }
        }
        
        return dup;
    }
}