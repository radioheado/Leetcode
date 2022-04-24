class UndergroundSystem {
    private Map<Integer, Pair<String, Integer>> customer = new HashMap<>();
    private Map<Pair<String, String>, Pair<Double, Integer>> travel = new HashMap<>();

    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        customer.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String end, int t) {
        Pair<String, Integer> checkin = customer.get(id);
        String start = checkin.getKey();
        Integer depart = checkin.getValue();
        Pair<String, String> journey = new Pair<>(start, end);
        if (travel.containsKey(journey)) {
            Double avg = travel.get(journey).getKey();
            Integer cnt = travel.get(journey).getValue();
            Double new_avg = (avg*cnt + t-depart) / (cnt+1);
            travel.put(journey, new Pair<>(new_avg, cnt+1));
        } else {
            travel.put(journey, new Pair<>((double)t-depart, 1));
        }
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return travel.get(new Pair<>(startStation, endStation)).getKey();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */