public class ZigzagIterator {

    private Queue<Integer> q;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList();
        Iterator<Integer> t1 = v1.iterator();
        Iterator<Integer> t2 = v2.iterator();

        while (t1.hasNext() || t2.hasNext()) {
            if (t1.hasNext()) {
                q.offer(t1.next());
            }
            if (t2.hasNext()) {
                q.offer(t2.next());
            }
        }
    }

    public int next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */