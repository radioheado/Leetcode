class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        int[] result = new int[2];
        
        while(left < right){
            if(numbers[left] + numbers[right] > target){
                right--;
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }else{
                result = new int[] {left+1, right+1};
                break;
            }
        }
        
        return result;
    }
}