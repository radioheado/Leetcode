class Solution {
    public int lengthOfLastWord(String s) {
        int r = s.length()-1, l;
        while (r >= 0 && s.charAt(r) == ' ') {
             r--;
        }
        
        l = r-1;
        while (l >= 0 && s.charAt(l) != ' ') {
            l--;
        }
        
        return r-l;
    }
}