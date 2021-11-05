class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int start= 0;
        int end = 0;
        
        for(int i=0; i<s.length(); i++){
            //System.out.println("s.charAt(i) = " + s.charAt(i));
            for(int j=start; j<end; j++){
                if(s.charAt(i) == s.charAt(j)){
                    ans = Math.max(ans, end-start);
                    start = j+1;
                }    
            }
            end += 1;
            //System.out.println("start = " + start);
            //System.out.println("end = " + end);
        }
                 
        return Math.max(ans, end-start);
    }
}