class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int words = 1, idx = 0, sentenceLength = sentence.length();
        int wordLength = searchWord.length();

        while (idx < sentenceLength) {
            if (sentence.charAt(idx) == ' ') {
                idx++;
                words++;
                continue;
            }

            int matchCount = 0;
            if (sentence.charAt(idx) == searchWord.charAt(matchCount)) {
                while (idx < sentenceLength && matchCount < wordLength 
                   && sentence.charAt(idx) == searchWord.charAt(matchCount)) {
                    idx++;
                    matchCount++;
                } 
                if (matchCount == wordLength) {
                    return words;
                }
            } else {
                while (idx < sentenceLength && sentence.charAt(idx) != ' ') {
                    idx++;
                }
            }  

            
        }

        return -1;
    }
}