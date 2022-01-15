class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> count = new HashMap<>();
        for(int n: nums1){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        
        int i = 0;
        for(int n: nums2){
            int cnt = count.getOrDefault(n, 0);
            if(cnt > 0){
                nums1[i++] = n;
                count.put(n, cnt-1);
            }
        }
        
        return Arrays.copyOfRange(nums1, 0, i);
    }
}