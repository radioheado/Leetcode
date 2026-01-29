class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minNum = arr[0], maxNum = arr[0];
        for (int num: arr) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        int shift = -minNum, minDiff = maxNum - minNum + 1, pre = 0;
        int[] buckets = new int[maxNum - minNum + 1];
        for (int num: arr) {
            buckets[num + shift]++;
        }


        List<List<Integer>> ans = new ArrayList<>();
        for (int cur = 1; cur < buckets.length; cur++) {
            if (buckets[cur] == 0) {
                continue;
            }
            int curDiff = cur - pre;
            if (curDiff == minDiff) {
                ans.add(Arrays.asList(pre - shift, cur - shift));
            } else if (curDiff < minDiff) {
                ans.clear();
                ans.add(Arrays.asList(pre - shift, cur - shift));
                minDiff = curDiff;
            }
            pre = cur;
        }

        return ans;
    }
}