class Solution {
    public List<String> removeAnagrams(String[] words) {
        int[] last = countLetters(words[0]);
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        
        for (String word: words) {
            int[] cur = countLetters(word);
            if (Arrays.compare(last, cur) != 0) {
                last = cur;
                ans.add(word);
            }
        }

        return ans;
    }

    private int[] countLetters(String word) {
        int[] count = new int[26];
        for (char c: word.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }
}