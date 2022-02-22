class Solution {
    public int titleToNumber(String columnTitle) {
        char base = 'A';
        int ans = 0;
        int len = columnTitle.length();
        
        for(int i=len-1; i>=0; i--){
            char temp = columnTitle.charAt(i);
            ans += (temp-base+1) * Math.pow(26, len-i-1);
        }
        
        return ans;
    }
}