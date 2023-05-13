class Solution {
    public List<Integer> transformArray(int[] arr) {
        int N = arr.length;
        int[] cur = new int[N];
        cur[0] = arr[0];
        cur[N-1] = arr[N-1];
        boolean flag = true;
        
        while (flag) {
            flag = false;
            for (int i = 1; i < N - 1; i++) {
                if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                    cur[i] = arr[i] - 1;
                    flag = true;
                } else if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
                    cur[i] = arr[i] + 1;
                    flag = true;
                } else {
                    cur[i] = arr[i];
                }
            }
            arr = Arrays.copyOf(cur, N);
        }

        List<Integer> ans = new ArrayList();
        for (int n: arr) {
            ans.add(n);
        }

        return ans;
    }
}