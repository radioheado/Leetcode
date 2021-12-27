class Solution {
    public void duplicateZeros(int[] arr) {
        int zero = 0, count = 0, index = 0;
        while(count < arr.length){
            if(arr[index] == 0){
                zero++;
                count += 2;
            }else{
                count++;
            }
            index++;
        }
        
        //System.out.println("zero = " + zero);
        
        if(count > arr.length){
            arr[arr.length-1] = 0;
            int temp = arr.length-zero-1;
            for(int i = arr.length-2; i > 0; i--){
                //System.out.println("arr[temp] = " + arr[temp]);
                if(arr[temp] == 0){
                    arr[i] = 0;
                    arr[i-1] = 0;
                    i--;
                }else{
                    arr[i] = arr[temp];
                }
                temp--;
            }
        }else{
            int temp = arr.length-zero-1;
            for(int i = arr.length-1; i > 0; i--){
                if(arr[temp] == 0){
                    arr[i] = 0;
                    arr[i-1] = 0;
                    i--;
                }else{
                    arr[i] = arr[temp];
                    //System.out.println("arr[temp] = " + arr[temp]);
                }
                temp--;
            }
        }
    }
    
    
}