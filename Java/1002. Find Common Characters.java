class Solution {
    public List<String> commonChars(String[] words) {
        int[] chars = new int[26];
        for (char c: words[0].toCharArray()) {
            chars[c - 97]++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] temp = new int[26];
            for (char c: words[i].toCharArray()) {
                temp[c - 97]++;
            }

            for (int j = 0; j < 26; j++) {
                chars[j] = Math.min(chars[j], temp[j]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < chars[i]; j++) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }

        return ans;
    }
}