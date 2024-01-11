class Solution {
    public int buyChoco(int[] prices, int money) {
        int top = 101, sec = 101;
        for (int p: prices) {
            if (p <= top) {
                sec = top;
                top = p;
            } else if (p < sec) {
                sec = p;
            }
        }   

        return top + sec <= money ? money - top - sec : money;
    }
}