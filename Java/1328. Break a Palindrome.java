class Solution {
    public String breakPalindrome(String palindrome) {
        int L = palindrome.length();
        if (L == 1) {
            return "";
        }
        
        char[] array = palindrome.toCharArray();
        for (int i=0; i<L/2; i++) {
            if (array[i] != 'a') {
                array[i] = 'a';
                return String.valueOf(array);
            }
        }
        array[L-1] = 'b';
        return String.valueOf(array);
    }
}