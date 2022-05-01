class Solution {
    
    private HashMap<String, Pair<String, Double>> root = new HashMap<>();
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        for (int i=0; i<equations.size(); i++) {
            String x = equations.get(i).get(0), y = equations.get(i).get(1);
            Double val = values[i];
            union(x, y, val);
        }
        
        double[] res = new double[queries.size()];
        for (int j=0; j<queries.size(); j++) {
            List<String> query = queries.get(j);
            String x = query.get(0), y = query.get(1);
            
            /* case 1: at least one of the vars is not in root */
            if (!root.containsKey(x) || !root.containsKey(y)) {
                res[j] = -1.0;
            }
            else {
                Pair<String, Double> xpair = find(x), ypair = find(y);
                String xroot = xpair.getKey(), yroot = ypair.getKey();
                Double xval = xpair.getValue(), yval = ypair.getValue();
                
                /* case 2: x and y are not in the same group */
                if (!xroot.equals(yroot)) {
                    res[j] = -1.0;
                }
                /* case 3: x and y are in the same group */
                else {
                    res[j] = xval / yval;
                }
            }
        }
        
        return res;
    }
    
    
    private Pair<String, Double> find (String x) {
        if (!root.containsKey(x)) {
            root.put(x, new Pair<>(x, 1.0));
        }
        
        Pair<String, Double> pair = root.get(x);
        /* trigger chain update if x != pair.getKey() */
        if (!pair.getKey().equals(x)) {
            Pair<String, Double> rootPair = find(pair.getKey());
            root.put(x, new Pair<String, Double>(rootPair.getKey(), pair.getValue() * rootPair.getValue()));
        }
        
        return root.get(x);
    }
    
    
    private void union (String x, String y, Double val) {
        Pair<String, Double> xpair = find(x);
        Pair<String, Double> ypair = find(y);
        
        String xroot = xpair.getKey(), yroot = ypair.getKey();
        Double xval = xpair.getValue(), yval = ypair.getValue();
        
        /* merge x group and y group together */
        if (!xroot.equals(yroot)) {
            root.put(xroot, new Pair<String, Double>(yroot, yval * val / xval));
        }
    }
}