class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left= 0;
        int right = 0;
        int[] chars = new int[128];
        
        while(right < s.length()){
            chars[s.charAt(right)]++;
            
            while(chars[s.charAt(right)] > 1){
                chars[s.charAt(left)]--;
                left++;
            }
            
            ans = Math.max(ans, right-left+1);
            right++;
        }
                 
        return ans;
    }
}