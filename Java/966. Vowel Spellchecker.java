class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] ans = new String[queries.length];
        Set<String> exactMatches = new HashSet<>();
        Map<String, Integer> capMatches = new HashMap<>();
        Map<String, Integer> vowelMatches = new HashMap<>();
        int i = 0;

        for (String word: wordlist) {
            exactMatches.add(word);
            word = word.toLowerCase();
            capMatches.putIfAbsent(word, i);
            vowelMatches.putIfAbsent(devowel(word), i);
            i++;
        }

        i = 0;
        for (String query: queries) {
            if (exactMatches.contains(query)) {
                ans[i] = query;
            } else if (capMatches.containsKey(query.toLowerCase())) {
                ans[i] = wordlist[capMatches.get(query.toLowerCase())];
            } else if (vowelMatches.containsKey(devowel(query.toLowerCase()))) {
                ans[i] = wordlist[vowelMatches.get(devowel(query.toLowerCase()))];
            } else {
                ans[i] = "";
            }
            i++;
        }

        return ans;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c: word.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return ("aeiou".indexOf(c) != -1);
    }
}