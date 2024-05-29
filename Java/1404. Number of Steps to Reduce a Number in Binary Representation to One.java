class Solution {
    public int numSteps(String s) {
        int N = s.length(), steps = 0, carry = 0;

        for (int i = N - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;
            if (digit % 2 == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps++;
            }
        }

        return steps + carry;
    }
}