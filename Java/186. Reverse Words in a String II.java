class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int start = 0, end = 0;
        
        while(end < s.length){
            if(s[end] == ' '){
                reverse(s, start, end-1);
                start = end+1;
            }else if(end == s.length-1){
                reverse(s, start, end);
            }
            end++;
        }
    }
    
    private void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}