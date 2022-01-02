class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> res = new ArrayList<>();
        char[] chars = text.toCharArray();
        
        for(int i=0; i<chars.length; i++){
            for(String w: words){
                if(chars[i] == w.charAt(0)){
                    int l = w.length();
                    if(i+l <= text.length()){
                        String temp = text.substring(i, i+l);
                        if(temp.equals(w)){
                            res.add(new int[] {i, i+l-1});
                        }
                    }
                }
            }
        }
        
        Collections.sort(res, new Comparator<int[]>() { /* override sort */
	    @Override
	    public int compare(int[] o1, int[] o2) {
		for(int i = 0;i < o1.length;i++) {
		    if(o1[i] != o2[i]) return o1[i] - o2[i]; 
		    else continue;
		}
		return o1[0] - o2[0]; 
	    }
	});

        return res.toArray(new int[res.size()][2]);
    }
}