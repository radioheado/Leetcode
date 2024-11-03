class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int size = 0;
        for (char c: s.toCharArray()) {
            if (size >= 2 && c == sb.charAt(size - 1) && c == sb.charAt(size - 2)) {
                continue;
            }
            sb.append(c);
            size++;
        }
        return sb.toString();
    }
}