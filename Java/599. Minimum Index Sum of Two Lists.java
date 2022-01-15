class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map2 = new HashMap<>();
        for(int i=0; i<list2.length; i++){
            map2.put(list2[i], i);
        }
        
        int sumIdx = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        
        for(int i=0; i<list1.length; i++){
            if(map2.containsKey(list1[i])){
                int curIdx = i + map2.get(list1[i]);
                if(curIdx == sumIdx){
                    res.add(list1[i]);
                }else if(curIdx < sumIdx){
                    res.clear();
                    res.add(list1[i]);
                    sumIdx = curIdx;
                }
            }
        }
        
        String[] ans = new String[res.size()];
        for(int i=0; i<res.size(); i++){
            //System.out.println(res.get(i));
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}