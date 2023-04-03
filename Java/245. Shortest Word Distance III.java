class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int ans = wordsDict.length, i1 = -ans, i2 = ans;
        boolean same = word1.equals(word2);

        for (int i=0; i<wordsDict.length; i++) {
            if (word1.equals(wordsDict[i])) {
                if (same) {
                    i2 = i1;
                }
                i1 = i;
            } else if (word2.equals(wordsDict[i])) {
                i2 = i;
            }
            ans = Math.min(ans, Math.abs(i1 - i2));
        }

        return ans;
    }
}