class Solution {
    public String reverseVowels(String s) {
        int l = 0, r = s.length() - 1, left = -1, right = -1;
        char[] chars = s.toCharArray();
        
        while (l <= r) {
            if (isVowel(chars[l])) {
                if (left == -1) {
                    left = l++;
                }
            } else {
                l++;
            }
            
            if (isVowel(chars[r])) {
                if (right == -1) {
                    right = r--;
                }
            } else {
                r--;
            }
            
            if (left != -1 && right != -1) {
                swap(chars, left, right);
                left = right = -1;
            }
        }
        
        return new String(chars);
    }
    
    private void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'; 
    }
}