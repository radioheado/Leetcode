class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length-k;
        
        while(left < right){
            int mid = (right-left)/2 + left;
            
            /* arr[mid] is closer to x than arr[mid+k]
             * then numbers to the right of arr[mid+k] including itself can never be in the answer
             * because every number from arr[mid] to arr[mid+k-1] are eligible in this step
             * NOTE: we can understand it in this way: the closest number to x is between
             *       arr[left] and arr[right]
             */
            if(x-arr[mid] > arr[mid+k]-x){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for(int i=left; i<left+k; i++){
            answer.add(arr[i]);
        }
        
        return answer;
        
    }
}