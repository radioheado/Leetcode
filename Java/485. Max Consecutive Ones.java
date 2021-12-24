class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, m = 0;
        
        for(int num: nums){
            if(num != 1){
                m = Math.max(m, count);
                count = 0;
            }else{
                count++;
            }
        }
        
        return Math.max(m, count);
    }
}