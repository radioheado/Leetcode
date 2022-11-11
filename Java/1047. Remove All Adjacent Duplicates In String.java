class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int size = 0;
        
        for (char c: s.toCharArray()) {
            if (size > 0 && c == sb.charAt(size - 1)) {
                sb.deleteCharAt(--size);
            } else {
                sb.append(c);
                size++;
            }
        }
        
        return sb.toString();
    }
}