class Solution {
    public char findTheDifference(String s, String t) {
        int ord_diff = 0;
        for(int i=0; i<s.length(); i++){
            ord_diff -= (int)s.charAt(i);
            ord_diff += (int)t.charAt(i);
        }
        return (char)(ord_diff + (int)t.charAt(t.length()-1));
    }
}