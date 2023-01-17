class Solution {
    private char[] root = new char[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i=0; i<26; i++) {
            root[i] = (char)('a' + i);
        }

        for (int i=0; i<s1.length(); i++) {
            union(s1.charAt(i), s2.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (char c: baseStr.toCharArray()) {
            sb.append(find(c));
        }

        return sb.toString();
    }

    private char find(char x) {
        if (x != root[x - 'a']) {
            root[x - 'a'] = find(root[x - 'a']);
        }
        return root[x - 'a'];
    }

    private void union(char x, char y) {
        char rootx = find(x), rooty = find(y);
        if (rootx > rooty) {
            root[rootx - 'a'] = rooty;
        } else {
            root[rooty - 'a'] = rootx;
        }
    }
}