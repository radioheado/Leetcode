class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        Map<String, Set<String>> pairs = new HashMap();
        for (List<String> p: similarPairs) {
            pairs.computeIfAbsent(p.get(0), value -> new HashSet<>()).add(p.get(1));
            pairs.computeIfAbsent(p.get(1), value -> new HashSet<>()).add(p.get(0));      
        }


        for (int i=0; i<sentence1.length; i++) {
            String s = sentence1[i], t = sentence2[i];
            if (!s.equals(t)) {
                if (!pairs.containsKey(s) || !pairs.containsKey(t) || !pairs.get(s).contains(t)) {
                    return false;
                }
            }
        }

        return true;
    }
}