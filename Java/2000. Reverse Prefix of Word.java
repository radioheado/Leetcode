class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if (idx == -1) {
            return word;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (i <= idx) {
                sb.append(word.charAt(idx - i));
            } else {
                sb.append(word.charAt(i));
            }
        }

        return sb.toString();
       
    }
}