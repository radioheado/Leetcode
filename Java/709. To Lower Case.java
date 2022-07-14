class Solution {
    public String toLowerCase(String s) {
        int a = 'a';
        StringBuilder sb = new StringBuilder();
        
        for (char c: s.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                sb.append((char)(c | 32));
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}