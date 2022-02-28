class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        // edge case
        if(nums.length == 0) {
            return ans;
        }
        
        int l = nums.length;
        int start = nums[0];
        for(int i=1; i<l; i++) {
            if(nums[i] != nums[i-1]+1) {
                String temp;
                if(nums[i-1] != start) {
                    temp = String.valueOf(start) + "->" + String.valueOf(nums[i-1]);
                }else{
                    temp = String.valueOf(start);
                }
                ans.add(temp);
                start = nums[i];
            }
        }
        
        String temp;
        if(nums[l-1] != start) {
            temp = String.valueOf(start) + "->" + String.valueOf(nums[l-1]);
        }else{
            temp = String.valueOf(start);
        }
        
        ans.add(temp);
        return ans;
    }
}