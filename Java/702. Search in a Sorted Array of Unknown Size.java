/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 9999;
        
        while(left <= right){
            int mid = (right-left)/2 + left;
            int num = reader.get(mid);
            
            // found the target
            if(num == target){
                return mid;
            }else if(num < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        
        return -1;
    }
}