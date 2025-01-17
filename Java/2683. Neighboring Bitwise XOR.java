class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int sum = 0;
        for (int d: derived)    {
            sum += d;
        }
        return sum % 2 == 0;
    }
}