class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> j = new HashSet<>();
        for(int i=0; i<jewels.length(); i++){
            j.add(jewels.charAt(i));
        }
        
        int ans = 0;
        for(Character s: stones.toCharArray()){
            if(j.contains(s)){
                ans++;
            }
        }
        
        return ans;
    }
}