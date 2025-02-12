class Solution {
    public String removeOccurrences(String s, String part) {
        int p = part.length();
        while (s.contains(part)) {
            int i = s.indexOf(part);
            s = s.substring(0, i) + s.substring(i + p);
        }
        return s;
    }
}