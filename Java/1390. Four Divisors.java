class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> divisors = new HashMap<>();

        for (int num: nums) {
            if (divisors.containsKey(num)) {
                ans += divisors.get(num);
                continue;
            }
            ans += findDivisors(divisors, num);
        }

        return ans;
    }

    private int findDivisors(Map<Integer, Integer> divisors, int num) {
        int count = 0, sum = 0;
        for (int d = 1; d <= Math.floor(Math.sqrt(num)); d++) {
            if ((num / d) * d == num) {
                if (num / d != d) {
                    count++;
                    sum += num / d;
                }
                count++;
                sum += d;
            }

            if (count > 4) {
                break;
            }
        }
        
        if (count == 4) {
            divisors.put(num, sum);
        }

        return count == 4 ? sum : 0;
    }
}