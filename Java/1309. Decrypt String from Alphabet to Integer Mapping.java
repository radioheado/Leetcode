class Solution {
    public String freqAlphabets(String s) {
        int i = 0, a = 'a', l = s.length();
        StringBuilder sb = new StringBuilder();
        
        while (i < l) {
            if (i < l - 2 && s.charAt(i+2) == '#') {
                sb.append((char) ((int)Integer.valueOf(s.substring(i, i+2)) + a - 1));
                i += 2;
            } else {
                sb.append((char) (Character.getNumericValue(s.charAt(i)) + a - 1));
            }
            i++;
        }
        
         return sb.toString();
    }
}