class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        /* sort on increasing in env[0] and descresing in env[1] */
        Arrays.sort(envelopes, new Comparator<int[]>() {
           public int compare (int[] arr1, int[] arr2) {
               if (arr1[0] == arr2[0]) {
                   return arr2[1] - arr1[1];
               } else {
                   return arr1[0] - arr2[0];
               }
           } 
        });
        
        int[] nums = new int[envelopes.length];
        for (int i=0; i<envelopes.length; i++) {
            nums[i] = envelopes[i][1];
        }
        
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        int n, L = 1;
        
        for (int i=1; i<nums.length; i++) {
            n = nums[i];
            if (n > sub.get(L-1)) {
                sub.add(n);
                L++;
            } else {
                sub.set(bisect(sub, n), n);
            }
        }
        
        return L;
    }
    
    private int bisect (ArrayList<Integer> sub, int num) {
        int left = 0, right = sub.size()-1;
        int mid;
        
        while (left < right) {
            mid = (right-left) / 2 + left;
            if (sub.get(mid) == num) {
                return mid;
            }
            
            if (sub.get(mid) < num) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}