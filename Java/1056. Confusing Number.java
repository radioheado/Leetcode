class Solution {
    public boolean confusingNumber(int n) {
        Map<Integer, Integer> mapping = new HashMap();

        mapping.put(0, 0);
        mapping.put(1, 1);
        mapping.put(6, 9);
        mapping.put(8, 8);
        mapping.put(9, 6);

        int num = n, ans = 0, rem;
        while (num > 0) {
            rem = num % 10;
            if (!mapping.containsKey(rem)) {
                return false;
            }
            ans = ans * 10 + mapping.get(rem);
            num /= 10;
        }

        return ans != n;
    }
}