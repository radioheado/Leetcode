class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] judge = new int[n];
        
        for(int[] t: trust){
            judge[t[0]-1]++;
            judge[t[1]-1]--;
        }
        
        int ans = -1;
        for(int i=0; i<n; i++){
            if(judge[i] == -n+1){
                if(ans == -1){
                    ans = i+1;
                }else{
                    return -1;
                }
            }
        }
        
        return ans;
    }
}