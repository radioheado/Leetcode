class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int num = 0;
        for (int n: nums) {
            num = ((num << 1) + n) % 5;
            ans.add(num == 0);
        }
        return ans;
    }
}