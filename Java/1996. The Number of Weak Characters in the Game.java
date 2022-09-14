class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        /* find the max attack value */
        int maxAttack = 0;
        for (int[] p: properties) {
            maxAttack = Math.max(maxAttack, p[0]);
        }
        
        /* use an array to store the max defense value for each attack value*/
        int[] maxDefense = new int[maxAttack+2];
        for (int[] p: properties) {
            maxDefense[p[0]] = Math.max(maxDefense[p[0]], p[1]);
        }
        
        /* update max defense value backwards */
        for (int d=maxAttack-1; d>0; d--) {
            maxDefense[d] = Math.max(maxDefense[d], maxDefense[d+1]);
        }
        
        /* check for less than */
        int ans = 0;
        for (int[] p: properties) {
            if (p[1] < maxDefense[p[0]+1]) {
                ans++;
            }
        }
        
        return ans;
    }
}