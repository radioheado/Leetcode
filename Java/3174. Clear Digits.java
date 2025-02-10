class Solution {
    public String clearDigits(String s) {
        char[] chars = new char[s.length()];
        int p = 0;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                p--;
            } else {
                chars[p++] = c;
            }
        }
        return new String(chars, 0, p);
    }
}