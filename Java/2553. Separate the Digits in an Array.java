class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num: nums) {
            List<Integer> tmp = new ArrayList<>();
            while (num > 0) {
                tmp.add(num % 10);
                num /= 10;
            }
            ans.addAll(tmp.reversed());
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}