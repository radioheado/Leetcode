class Solution {
    public int maxProduct(int n) {
        int first = -1, second = -1;
        while (n > 0) {
            int rem = n % 10;
            if (rem >= first) {
                second = first;
                first = rem;
            } else if (rem > second) {
                second = rem;
            }
            n /= 10;
        }
        return first * second;
    }
}