class Solution {
    public int appendCharacters(String s, String t) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(p)) {
                p++;
                if (p == t.length()) {
                    break; 
                }
            }
        }
        return t.length() - p;
    }
}