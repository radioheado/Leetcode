class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        int[] n1 = new int[101];
        int[] n2 = new int[101];
        
        for (int i=0; i<nums1.length; i++) {
            n1[nums1[i]]++;
            n2[nums2[i]]++;
        }
        
        int p1 = 0, p2 = 100, ans = 0;
        int min;
        
        while (p1 < 101 && p2 > 0) {
            while (p1 < 101 && n1[p1] == 0) {
                p1++;
            }
            while (p2 > 0 && n2[p2] == 0) {
                p2--;
            }
            
            if (p1 == 101 || p2 == 0) {
                break;
            }
            
            min = Math.min(n1[p1], n2[p2]);
            ans += min*p1*p2;
            n1[p1] -= min;
            n2[p2] -= min;
        }
        
        return ans;
    }
}