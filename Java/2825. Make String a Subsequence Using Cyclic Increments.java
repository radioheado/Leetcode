class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i1 = 0, i2 = 0, s1 = str1.length(), s2 = str2.length();
        while (i1 < s1 && i2 < s2) {
            char c1 = str1.charAt(i1), c2 = str2.charAt(i2);
            if (c1 == c2 || ((c1 - 'a' + 1) % 26) == (c2 - 'a')) {
                i2++;
            }
            i1++;
        }
        return i2 == s2;
    }
}