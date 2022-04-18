class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i=0; i<l.length; i++) {
            ans.add(checkArithmetic(Arrays.copyOfRange(nums, l[i], r[i]+1)));
        }
        return ans;
    }
    
    private boolean checkArithmetic(int[] arr){
        if (arr.length <= 2) {
            return true;
        }
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i=2; i<arr.length; i++) {
            if (arr[i] - arr[i-1] != diff) {
                return false;
            }
        }
        return true;
    }
    
}