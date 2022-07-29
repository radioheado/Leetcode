import java.util.NoSuchElementException;
class Vector2D {
    private int[][] list;
    private int p1 = 0, p2 = 0, l;

    public Vector2D(int[][] vec) {
        list = vec;
        l = vec.length;
    }
    
    private void skip() {
        // skip the empty sub vecs
        while (p1 < l && p2 == list[p1].length) {
            p1++;
            p2 = 0;
        }
    }
    
    public int next() {
        if (!hasNext()) throw new NoSuchElementException();
        return list[p1][p2++];
    }
    
    public boolean hasNext() {
        skip();
        return p1 < l;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */