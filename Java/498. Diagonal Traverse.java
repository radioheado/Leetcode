class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, ArrayList<Integer>> diagonals = new HashMap<>();
        int m = mat.length, n = mat[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!diagonals.containsKey(i+j)){
                    diagonals.put(i+j, new ArrayList<Integer>());
                }
                diagonals.get(i+j).add(mat[i][j]);
            }
        }
        
        int[] result = new int[m*n];
        int index = 0;
        
        /* IMPORTANT: must make i<m+n-1 instead of just m+n
         * for example, m=3, n=3, the right bottom element is mat[2][2]
         * thus, i+j = 4 < m+n-1
         * i+j can never reach to 5 
         */
        for(int i=0; i<m+n-1; i++){
            ArrayList<Integer> temp = diagonals.get(i);
            //System.out.println(i);
            //System.out.println(temp);
            if(i%2 == 0){
                Collections.reverse(temp);
            }
            for(int j=0; j<temp.size(); j++){
                result[index] = temp.get(j);
                index++;
            }
        }
        
        return result;
    }
}