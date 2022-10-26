class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1 = word1.length, w2 = word2.length;
        int p1 = 0, p2 = 0, i1 = 0, i2 = 0;
        
        while (i1 < w1 && i2 < w2) {
            if (word1[i1].charAt(p1) != word2[i2].charAt(p2)) {
                return false;
            }
            p1++;
            p2++;
            
            // reach to the end of current word in word1
            if (p1 == word1[i1].length()) {
                p1 = 0;
                i1++;
            }
            
            // reach to the end of current word in word2
            if (p2 == word2[i2].length()) {
                p2 = 0;
                i2++;
            }
        }
        
        // IMPORTANT: final check
        return i1 == w1 && i2 == w2;
    }
}