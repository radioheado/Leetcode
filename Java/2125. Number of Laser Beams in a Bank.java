class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0, pre = 0;
        for (String beams: bank) {
            int count = 0;
            for (char c: beams.toCharArray()) {
                if (c == '1') {
                    count++;
                }
            }

            if (count > 0) {
                ans += pre * count;
                pre = count;
            }
        }
        
        return ans;
    }
}