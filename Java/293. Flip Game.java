class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        String valid = "++", target = "--";
        List<String> ans = new ArrayList();

        for (int i=0; i<currentState.length()-1; i++) {
            if (valid.equals(currentState.substring(i, i+2))) {
                ans.add(currentState.substring(0, i) + target + currentState.substring(i+2));
            }
        }

        return ans;
    }
}