class Solution {
    public int minSwaps(String s) {
        int count = 0;
        for (char c: s.toCharArray()) {
            if (count > 0 && c == ']') {
                count--;
            } else {
                count++;
            }
        }

        return (count + 1) / 2;
    }
}