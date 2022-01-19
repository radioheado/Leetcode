class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }
        
        int mid = nums.length/2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        
        return merge(left, right);
    }
    
    private int[] merge(int[] n1, int[] n2){
        int i1 = 0, i2 = 0, i = 0;
        int[] ans = new int[n1.length + n2.length];
        
        while(i1 < n1.length && i2 < n2.length){
            if(n1[i1] <= n2[i2]){
                ans[i++] = n1[i1++];
            }else{
                ans[i++] = n2[i2++];
            }
        }
        
        while(i1 < n1.length){
            ans[i++] = n1[i1++];
        }
        
        while(i2 < n2.length){
            ans[i++] = n2[i2++];
        }
        
        return ans;
    }
}