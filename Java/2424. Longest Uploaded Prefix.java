class LUPrefix {
    boolean[] uploaded;
    int prefix;

    public LUPrefix(int n) {
        uploaded = new boolean[n];
        Arrays.fill(uploaded, false);
        prefix = 0;
    }
    
    public void upload(int video) {
        uploaded[video - 1] = true;
        while (prefix < uploaded.length && uploaded[prefix]) {
            prefix++;
        }
    }
    
    public int longest() {
        return prefix;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */