class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int space_idx = 0;

        for (int i = 0; i < s.length(); i++) {
            if (space_idx < spaces.length && i == spaces[space_idx]) {
                sb.append(' ');
                space_idx++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}