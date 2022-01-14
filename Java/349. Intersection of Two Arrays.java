class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int n: nums1){
            set1.add(n);
        }
        
        for(int n: nums2){
            set2.add(n);
        }
        
        set1.retainAll(set2);
        
        int[] res = new int[set1.size()];
        int i = 0;
        for(int s: set1){
            res[i++] = s;
        }
        return res;
    }
}