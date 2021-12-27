class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(String str: strs){
            char[] temp = str.toCharArray();
            reverse(temp);
            //System.out.println(temp);
            str = new String(temp);
            System.out.println(str);
            result.append(str + " ");
        }
        
        
        return result.toString().trim();
    }
    
    private void reverse(char[] s){
        int start = 0, end = s.length-1;
        while(start < end){
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}