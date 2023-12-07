class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7, days = n % 7, total = 0, monday = 1;
        for (int w = 0; w < weeks; w++) {
          total += (monday++ * 2 + 6) * 7 / 2;
        }
        total += (monday * 2 + days - 1) * days / 2;
        return total;
    }
}