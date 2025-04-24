class RangeFreqQuery {
    private Map<Integer, List<Integer>> positions;

    public RangeFreqQuery(int[] arr) {
        positions = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            positions.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        if (!positions.containsKey(value)) {
            return 0;
        }

        List<Integer> idx = positions.get(value);
        int l = lowerBound(idx, left), r = upperBound(idx, right);
        return r - l;
    }

    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int upperBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */