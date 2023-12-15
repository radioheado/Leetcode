class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> out = new HashMap();
        for (List<String> path: paths) {
            out.put(path.get(0), out.getOrDefault(path.get(0), 0) + 1);
            out.put(path.get(1), out.getOrDefault(path.get(1), 0));
        }

        for (String city: out.keySet()) {
            if (out.get(city) == 0) {
                return city;
            }
        }

        return new String();
    }
}