class Solution {
    public String reverseWords(String s) {
        // remove leading and ending spaces
        s = s.trim();
        String[] arr = s.split("\\s+");
        reverse(arr);
        return String.join(" ", arr);
    }
    
    private void reverse(String[] s){
        int start = 0, end = s.length-1;
        while(start < end){
            String temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}