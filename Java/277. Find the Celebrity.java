/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            int cand = 0;
            for (int i=0; i<n; i++) {
                if (!knows(i, cand)) {
                    cand = i;
                }
            }
            if (isCelebrity(n, cand)) return cand;
            return -1;
        }
        
        private boolean isCelebrity(int n, int cand) {
            for (int j=0; j<n; j++) {
                if (cand == j)  continue;
                if (knows(cand, j) || !knows(j, cand))  return false;
            }
            return true;
        }
    }