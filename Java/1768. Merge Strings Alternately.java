class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int p1 = 0, p2 = 0, l1 = word1.length(), l2 = word2.length();
        
        while (p1 < l1 && p2 < l2) {
            ans.append(word1.charAt(p1++));
            ans.append(word2.charAt(p2++));
        }
        ans.append(word1, p1, l1);
        ans.append(word2, p2, l2);
        
        return ans.toString();
    }
}