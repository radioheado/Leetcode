class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        String[] rows = new String[numRows];
        Arrays.fill(rows, "");
        int row = 0;
        boolean backwards = true;

        for (char c: s.toCharArray()) {
            rows[row] += c;
            
            if (row == 0 || row == numRows - 1) {
                backwards = !backwards;
            }

            if (backwards) {
                row--;
            } else {
                row++;
            }
        }
        

        String ans = new String();
        for (String sb: rows) {
            ans += sb.toString();
        }

        return ans;
    }
}