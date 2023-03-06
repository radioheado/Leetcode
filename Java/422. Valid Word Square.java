class Solution {
    public boolean validWordSquare(List<String> words) {
        int rows = words.size();

        for (int r = 0; r < rows; r++) {
            String row = words.get(r);
            int row_len = row.length();

            for (int i = 0; i < row_len; i++) {
                if (i >= rows || r >= words.get(i).length() || row.charAt(i) != words.get(i).charAt(r)) {
                    return false;
                }
            }
        }

        return true;
    }
}