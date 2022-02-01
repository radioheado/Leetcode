class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        if(len1 > len2){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = nums1.length;
            len2 = nums2.length;
        }
        
        int left = 0, right = len1-1;
        int total = len1 + len2;
        int half = total/2;
        double ans = 0;
        /*
        for(int n: nums1){
            System.out.print(n);
        }
        */
        
        while(true){
            int mid = Math.floorDiv(right-left, 2) + left;
            int needs = half - mid - 2;
            
            int Aleft = mid >= 0 ? nums1[mid] : Integer.MIN_VALUE;
            int Aright = mid < len1 - 1 ? nums1[mid+1] : Integer.MAX_VALUE;
            int Bleft = needs >= 0 ? nums2[needs] : Integer.MIN_VALUE;
            int Bright = needs < len2 - 1 ? nums2[needs+1] : Integer.MAX_VALUE;
            //System.out.println("Aleft = " + Aleft + ", Bright = " + Bright + ", Bleft = " + Bleft + ", Aright = " + Aright);
            
            if(Aleft <= Bright && Bleft <= Aright){
                // odd
                if(total%2 == 1){
                    ans = Math.min(Aright, Bright);
                    break;
                }
                // even
                ans = (Math.max(Aleft, Bleft) + Math.min(Aright, Bright))/2d;
                break;
            }else if(Aleft > Bright){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        
        return ans;
        
    }
}