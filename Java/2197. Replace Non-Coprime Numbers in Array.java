class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();
        for (int num: nums) {
            while (!stack.isEmpty()) {
                long g = gcd((long) num, (long) stack.getLast());
                if (g == 1) {
                    break;
                }
                num *= (stack.removeLast() / g);
            }
            stack.add(num);
        }
        return stack;
    }

    private static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;  // |gcd(a,b)| ; gcd(x,0) = |x| ; gcd(0,0) = 0 here if you want
    }

}