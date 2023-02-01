class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> heap = new PriorityQueue((new Comparator<Element>() {
			public int compare(Element a, Element b) {
				return a.val - b.val;
			}
		}));

        int min = -100000, max = 100000, left, right = -100000, row, idx;
        for (int i=0; i<nums.size(); i++) {
            heap.offer(new Element(nums.get(i).get(0), i, 0));
            right = Math.max(right, nums.get(i).get(0));
        }

        while (!heap.isEmpty()) {
            Element e = heap.poll();
            left = e.val;
            row  = e.row;
            idx  = e.idx;

            if (right - left < max - min) {
                min = left;
                max = right;
            }

            idx++;
            if (idx == nums.get(row).size()) {
                break;
            }
            
            right = Math.max(right, nums.get(row).get(idx));
            heap.offer(new Element(nums.get(row).get(idx), row, idx));
        }

        return new int[] {min, max};
    }

    class Element {
        int val, row, idx;

        public Element (int v, int r, int i) {
            val = v;
            row = r;
            idx = i;
        }
    }
}