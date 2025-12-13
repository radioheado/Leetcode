class Solution {
    public List<String> validateCoupons(String[] codes, String[] businessLine, boolean[] isActive) {
        Map<String, Integer> validLines = new HashMap<>();
        validLines.put("electronics", 0);
        validLines.put("grocery", 1);
        validLines.put("pharmacy", 2);
        validLines.put("restaurant", 3);
        List<List<String>> lists = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lists.add(new ArrayList<>());
        }
        

        for (int i = 0; i < codes.length; i++) {
            String code = codes[i], line = businessLine[i];
            if (!isActive[i] || !validLines.containsKey(line) || !isValid(code)) {
                continue;
            }
            
            lists.get(validLines.get(line)).add(code);
        }

        List<String> ans = new ArrayList<>();
        for (List<String> list: lists) {
            Collections.sort(list);
            ans.addAll(list);
        }

        return ans;
    }

    private boolean isValid(String code) {
        if (code.isEmpty()) {
            return false;
        }

        boolean flag = true;
        for (char c: code.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_') {
                flag = false;
                break;
            }
        }
        return flag;
    }
}